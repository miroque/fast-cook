package ru.miroque.fastcook.bean;

import java.util.concurrent.TimeUnit;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

@Stateless
public class Kitchen {
	
	private final Logger log = Logger.getLogger(getClass());
	
//	@Asynchronous
	public void recievedOrder(@Observes String mark) throws InterruptedException {
		log.info("recievedOrder <-");
		log.infov("::<>:mark:{0}",mark);
		if (mark.equals("add Order")) {
			TimeUnit.SECONDS.sleep(3);
			log.info("here start to work on order");
			log.info("select cook or cook self choose dish and cooks it");
		} else {
			log.info("else if");
		}
		log.info("recievedOrder ->");
	}
	
	void cookTheOrders() {
		
	}
}
