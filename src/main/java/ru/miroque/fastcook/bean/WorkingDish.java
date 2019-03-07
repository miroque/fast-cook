package ru.miroque.fastcook.bean;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.jboss.logging.Logger;

import ru.miroque.fastcook.domains.Cook;
import ru.miroque.fastcook.domains.CookStep;
import ru.miroque.fastcook.domains.Dish;

public class WorkingDish implements Callable<Void> {
	private final Logger log = Logger.getLogger(getClass());
	private Dish         dish;
	private Cook         cook;

	public WorkingDish() {
	}

	public WorkingDish(Dish dish, Cook cook) {
		this.dish = dish;
		this.cook = cook;
	}

	@Override
	public Void call() throws Exception {
		//::TODO: ага. а если свободная минутка, как он может создать новый поток?
		final String originalThreadName = Thread.currentThread().getName();
		Thread.currentThread().setName(originalThreadName + " <|> " +cook.getName());
		try {
			for (CookStep step : dish.getRecipe().getSteps()) {
				log.infov("::cooking: {0} :in {1} time-unit: this should be watchable?: {2}", step.getName(),
						step.getTime(), step.getDoing());
				TimeUnit.MILLISECONDS.sleep(step.getTime()*250);
			}
			log.infov("::cooking {0}:done!:", dish.getRecipe().getName()); 
		} finally {
			Thread.currentThread().setName(originalThreadName);
		}
		return null;
	}

}
