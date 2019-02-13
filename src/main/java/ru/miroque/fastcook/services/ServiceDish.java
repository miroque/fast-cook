package ru.miroque.fastcook.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ru.miroque.fastcook.domains.Dish;
import ru.miroque.fastcook.domains.Recipe;

// @todo #1 подумать а действительно ли тут апликашен скоуп или же надо реквест?
@ApplicationScoped
public class ServiceDish {

	public List<Dish> getDefaultListOfDishes() {
		ServiceRecipe serviceRecipe = new ServiceRecipe();
		List<Dish> items = new ArrayList<Dish>();
		for (int i = 0; i < 3; i++) {
			Dish item = new Dish();
			item.setPrice(Math.random() * 10);
			item.setRecipe(serviceRecipe.getRandomDefaultRecipe());
			items.add(item);
		}
		return items;
	}

}
