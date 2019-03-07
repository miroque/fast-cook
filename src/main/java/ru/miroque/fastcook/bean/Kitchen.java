package ru.miroque.fastcook.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Asynchronous;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.logging.Logger;

import ru.miroque.fastcook.conc.TransactionSupportCallableTask;
import ru.miroque.fastcook.dao.RepoRecipeDao;
import ru.miroque.fastcook.domains.Cook;
import ru.miroque.fastcook.domains.CookStep;
import ru.miroque.fastcook.domains.Dish;
import ru.miroque.fastcook.domains.Order;
import ru.miroque.fastcook.domains.Recipe;

@ApplicationScoped
public class Kitchen {
	@Resource
	ManagedExecutorService executor;

	private Set<Cook> employees;

	private final Logger log = Logger.getLogger(getClass());

	@Inject
	private RepoRecipeDao recipesRepo;

	@Inject
	private RepoOrders reposOrders;

	@Inject
	private Event<String> event;

	@PostConstruct
	private void actio() {
		log.info("@PostConstruct <-");
		employees = new HashSet<Cook>();

		Cook _01 = new Cook();
		_01.setName("Nick Alonso");
		List<Recipe> _01canDo = new ArrayList<Recipe>();
		_01canDo.add(recipesRepo.getRecipes().get(0));
		_01canDo.add(recipesRepo.getRecipes().get(1));
		_01.setCanDo(_01canDo);

		Cook _02 = new Cook();
		_02.setName("Mick Jagger");
		List<Recipe> _02canDo = new ArrayList<Recipe>();
		_02canDo.add(recipesRepo.getRecipes().get(2));
		_02canDo.add(recipesRepo.getRecipes().get(3));
		_02.setCanDo(_02canDo);
		employees.add(_01);
		employees.add(_02);
		log.infov("::cooks:{0}", employees);
		log.info("@PostConstruct ->");
	}

	@Asynchronous
	public void recievedOrder(@Observes String mark) throws InterruptedException {
		log.info("recievedOrder <-");
		log.infov("::<>:mark:{0}", mark);
		if (mark.equals("add Order")) {
			TimeUnit.SECONDS.sleep(3);
			log.info("here start to work on order");
			log.info("select cook or cook self choose dish and cooks it");
//			event.fire("go");
			cookTheOrders();
		} else {
			log.info("else if");
		}
		log.info("recievedOrder ->");
	}

	void cookTheOrders() throws InterruptedException {
		log.info("cookTheOrders <-");
		while (!reposOrders.getRecievedOrders().isEmpty()) {
			// кто из поваров свободен
			// кто из них может готовить это блюдо
			// начинай готовить

			for (Entry<Order, Boolean> entry : reposOrders.getRecievedOrders().entrySet()) {
				if (!entry.getValue()) {
					Order order = entry.getKey();
//					Future<Void> futureResult = null;
					for (Dish dish : order.getItems()) {
						// TODO: здесь отбирать кто из поваров может готовить это блюдо.
						for (Cook cook : employees) {
							log.info("   ::searching cook that may cook this dish:");
							for (Recipe recipe : cook.getCanDo()) {
								if (recipe.equals(dish.getRecipe())) {
									log.info("    ::make this cook do dish:");					
									executor.submit(new WorkingDish(dish, cook));
								}
							}
						}
					}
					entry.setValue(Boolean.TRUE);
				} else {
					reposOrders.getRecievedOrders().remove(entry.getKey());
					log.info("::order removed:");
				}
			}
		}
		log.info("cookTheOrders ->");
	}
}
