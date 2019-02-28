/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/tutorial-examples/LICENSE.txt
 */
package ru.miroque.fastcook.conc;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.jboss.logging.Logger;

import ru.miroque.fastcook.domains.Dish;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup",
//            propertyValue = "jms/MyQueue"),
    		  propertyValue = "java:/jms/queue/DLQ"),
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class CookPipleMessageBean implements MessageListener {

    @Resource
    private MessageDrivenContext mdc;
    private final Logger log = Logger.getLogger(getClass());

    public CookPipleMessageBean() {
    }

    /* (non-Javadoc)
     * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
     */
    @SuppressWarnings("unchecked")
	@Override
    public void onMessage(Message inMessage) {

        try {
            if (inMessage instanceof TextMessage) {
                log.infov("MESSAGE BEAN: Message received: {0}",
                        inMessage.getBody(String.class));
            } else if (inMessage instanceof ObjectMessage) {
            	List<Dish> tmp = inMessage.getBody(ArrayList.class);
            	// @todo #3 вот тут то и кулинарничать ассинхронно
            	log.infov("::Order with list size: {0}", tmp.size() );
            } else {
            	log.warnv("Message of wrong type: {0}",
                        inMessage.getClass().getName());
            }
        } catch (JMSException e) {
            log.error("SimpleMessageBean.onMessage: JMSException: {}"+
                    e.toString());
            mdc.setRollbackOnly();
        }
    }
}
