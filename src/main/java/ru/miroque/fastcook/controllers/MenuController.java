package ru.miroque.fastcook.controllers;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ru.miroque.fastcook.domains.Dish;
import ru.miroque.fastcook.services.ServiceDish;

@Named
@ApplicationScoped
public class MenuController {

	@Inject private ServiceDish serviceDish;
	
	public List<Dish> getMenu(){
		return serviceDish.getDefaultListOfDishes();
	}
}
