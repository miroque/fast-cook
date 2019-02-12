package ru.miroque.fastcook.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import lombok.Getter;
import ru.miroque.fastcook.domains.Dish;

// @todo #1 Вывод меню для заказа 
@ApplicationScoped
@Named
public class ServiceMenu {
	@Getter
	private List<Dish> menu;
	
	@PostConstruct
	private void init() {
		//@todo #1 сервис инициализации списка блюд
		// в отдельный класс сервис
	}
}