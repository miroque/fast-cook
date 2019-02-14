package ru.miroque.fastcook.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lombok.Getter;
import ru.miroque.fastcook.domains.Dish;

@ApplicationScoped
public class ServiceMenu {
	@Getter
	private List<Dish> menu;
	
	@Inject
	private ServiceDish serviceDish;
	
	@PostConstruct
	private void init() {
		menu = serviceDish.getDefaultListOfDishes();
	}
}