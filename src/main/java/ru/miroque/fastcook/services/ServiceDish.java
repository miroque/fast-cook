package ru.miroque.fastcook.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ru.miroque.fastcook.domains.Dish;

@RequestScoped
public class ServiceDish {
	@Inject private ServiceRecipe serviceRecipe;

	public List<Dish> getDefaultListOfDishes() {
		List<Dish> items = new ArrayList<Dish>();
		for (int i = 0; i < 3; i++) {
			Dish item = new Dish();
			item.setId(i);
			item.setPrice(Math.random() * 10);
			item.setRecipe(serviceRecipe.getRandomDefaultRecipe());
			items.add(item);
		}
		return items;
	}

}
