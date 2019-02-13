package ru.miroque.fastcook.services;

import org.junit.jupiter.api.Test;
/**
 * Это не классические юнит тесты, а чисто для самого себя проверка идеи.
 * @author panov
 *
 */
class ServiceRecipeTest {

	@Test
	void testGetRandomDefaultRecipe() {
		ServiceRecipe service = new ServiceRecipe();
		System.out.println(service.getRandomDefaultRecipe());
	}

}
