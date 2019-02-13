package ru.miroque.fastcook.services;

import org.junit.jupiter.api.Test;


/**
 * Это не классические юнит тесты, а чисто для самого себя проверка идеи.
 * @author panov
 *
 */
class ServiceDishTest {

	@Test
	void testGetDefaultListOfDishes() {
		ServiceDish service = new ServiceDish();
		service.getDefaultListOfDishes().stream().forEach(i->System.out.printf("item: %s price: %.2f рублей%n",i.getRecipe().getName(),i.getPrice()));
	}

}
