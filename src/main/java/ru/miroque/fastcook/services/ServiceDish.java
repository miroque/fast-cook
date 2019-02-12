package ru.miroque.fastcook.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ru.miroque.fastcook.domains.Dish;

// @todo #1 подумать а действительно ли тут апликашен скоуп или же надо реквест?
@ApplicationScoped
public class ServiceDish {

	public List<Dish> getDefaultListOfDishes() {
		/* @todo #1 сервис который бы сделал рандомные блюда */
		return null;
	}

}
