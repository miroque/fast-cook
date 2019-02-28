package ru.miroque.fastcook.conc;

import java.util.concurrent.Callable;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

public class TransactionSupportCallableTask implements Callable<String> {
	
    private int messageIndex;
    
    public TransactionSupportCallableTask() {
    }

    public TransactionSupportCallableTask(int messageId) {
        this. messageIndex = messageId;
    }

    public String call() throws NamingException {
    	//это работает
    	UserTransaction tx = (UserTransaction) new InitialContext().lookup("java:jboss/UserTransaction");
        String message = null;
        try {
            tx.begin();
            message = getMessage(messageIndex);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                tx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return message;
    }

//    private void getMessage(int index) { … }
    private String getMessage(int index) { return "getMessage(int "+index+")";}

//    private UserTransaction lookupUserTransaction () { … }

}
