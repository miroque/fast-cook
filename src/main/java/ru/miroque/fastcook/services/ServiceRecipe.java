package ru.miroque.fastcook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.ApplicationScoped;

import ru.miroque.fastcook.domains.CookStep;
import ru.miroque.fastcook.domains.Recipe;

@ApplicationScoped
public class ServiceRecipe {
	private List<Recipe> recipes;

	private void initRecipes() {
		recipes = new ArrayList<Recipe>();

		List<CookStep> pirozjok = new ArrayList<CookStep>();
		pirozjok.add(new CookStep("Замесить тесто", 15, Boolean.TRUE));
		pirozjok.add(new CookStep("Ждать поднимится", 60, Boolean.FALSE));
		pirozjok.add(new CookStep("Заложить начинку", 15, Boolean.TRUE));
		pirozjok.add(new CookStep("Поставить в духовку", 25, Boolean.FALSE));
		pirozjok.add(new CookStep("Вынуть из духовки", 5, Boolean.TRUE));
		Recipe recipe01 = new Recipe("Пирожок", pirozjok);
		recipes.add(recipe01);

		List<CookStep> bulka = new ArrayList<CookStep>();
		bulka.add(new CookStep("Замесить тесто", 15, Boolean.TRUE));
		bulka.add(new CookStep("Ждать поднимится", 30, Boolean.FALSE));
		bulka.add(new CookStep("Сформировать", 15, Boolean.TRUE));
		bulka.add(new CookStep("Поставить в духовку", 25, Boolean.FALSE));
		bulka.add(new CookStep("Вынуть из духовки", 5, Boolean.TRUE));
		Recipe recipe02 = new Recipe("Булка", bulka);
		recipes.add(recipe02);

		List<CookStep> riba = new ArrayList<CookStep>();
		riba.add(new CookStep("Очистить рыбу", 20, Boolean.TRUE));
		riba.add(new CookStep("Сформировать блюдо", 5, Boolean.TRUE));
		riba.add(new CookStep("Поставить в духовку", 25, Boolean.FALSE));
		riba.add(new CookStep("Вынуть из духовки", 5, Boolean.TRUE));
		Recipe recipe03 = new Recipe("Рыба", riba);
		recipes.add(recipe03);

		List<CookStep> chai = new ArrayList<CookStep>();
		chai.add(new CookStep("Вскипятить чайник", 3, Boolean.FALSE));
		chai.add(new CookStep("Закинуть пакетик чая", 1, Boolean.TRUE));
		chai.add(new CookStep("Подождать пока завариться", 3, Boolean.FALSE));
		Recipe recipe04 = new Recipe("Чай", chai);
		recipes.add(recipe04);
	}

	public Recipe getRandomDefaultRecipe() {
		if (recipes == null || recipes.isEmpty()) {
			initRecipes();
		}
		int randomNum = ThreadLocalRandom.current().nextInt(0, recipes.size());
		return recipes.get(randomNum);
	}

}
