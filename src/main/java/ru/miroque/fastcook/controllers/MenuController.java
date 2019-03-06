package ru.miroque.fastcook.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;

import org.jboss.logging.Logger;

import lombok.Getter;
import lombok.Setter;
import ru.miroque.fastcook.bean.RepoOrders;
import ru.miroque.fastcook.domains.Dish;
import ru.miroque.fastcook.domains.Order;
import ru.miroque.fastcook.services.ServiceDish;

@Named
@ViewScoped
public class MenuController implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(getClass());
	
	@Inject
//	@JMSConnectionFactory("jms/MyConnectionFactory")
	@JMSConnectionFactory("java:/ConnectionFactory")
	private JMSContext context;

//	@Resource(lookup = "jms/MyQueue")
	@Resource(lookup = "java:/jms/queue/DLQ")
	private Queue queue;

	@Getter @Setter
	private List<Dish> menu;

	@Getter @Setter
	private List<Dish> selected;

	@Inject
	private ServiceDish serviceDish;
	
	@Inject
	private RepoOrders orders;

	@PostConstruct
	private void initMenu() {
		log.info("initMenu <-");
		menu = serviceDish.getDefaultListOfDishes();
		log.info("::menu size: " + menu.size());
		selected = new ArrayList<>();
		for (Dish item : selected) {
			log.info("::selected:item " + item);
		}
		log.info("initMenu ->");
	}

	public void makeOrder() {
		log.info("makeOrder <-");
		try {
			Order item = new Order();
			item.setNumber(ThreadLocalRandom.current().nextInt(0, 100 + 1));
			item.setItems(selected);
			orders.addOrder(item);
			log.infov("::order:sended: {0}", item);
//		context.createProducer().send(queue, (ArrayList<Dish>)selected);
		}catch (Exception e) {
			log.errorv("Some error when send message: {0}", e.getMessage());
		}
		log.info("makeOrder ->");
	}

}
