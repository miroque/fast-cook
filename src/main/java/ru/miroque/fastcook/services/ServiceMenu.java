package ru.miroque.fastcook.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import lombok.Getter;
import ru.miroque.fastcook.domains.Dish;

// @todo #1 Вывод меню для заказа 
@ApplicationScoped
@Named
public class ServiceMenu {
	@Getter
	private List<Dish> menu;
	
	@Inject
	private ServiceDish serviceDish;
	
	@PostConstruct
	private void init() {
		// @todo #2 сервис инициализации списка блюд
		// и что я это должен отдельным что ли включать?
		menu = serviceDish.getDefaultListOfDishes();
	}
}