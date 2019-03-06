package ru.miroque.fastcook.bean;

import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import ru.miroque.fastcook.domains.Order;

@ApplicationScoped
public class RepoOrders {
	
	private final Logger log = Logger.getLogger(getClass());

	private ConcurrentHashMap<Order, Boolean> recievedOrders;
	private ConcurrentHashMap<Order, Boolean> cookingOrders;
	private ConcurrentHashMap<Order, Boolean> doneOrders;
	
	@Inject
	private Event<String> event;

	@PostConstruct
	private void initio() {
		recievedOrders = new ConcurrentHashMap<Order, Boolean>();
		doneOrders = new ConcurrentHashMap<Order, Boolean>();
		cookingOrders = new ConcurrentHashMap<Order, Boolean>();
	}
	
	public void addOrder(Order item) {
		log.info("addOrder <-");
		log.info("::<>::Order item:" + item);
		recievedOrders.put(item, Boolean.FALSE);
		log.info("::added Order to recieved orders:fire event:");
		event.fire("add Order");
		log.info("addOrder ->");
	}
}
