package ru.miroque.fastcook.services;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import ru.miroque.fastcook.dao.RepoRecipeDao;
import ru.miroque.fastcook.domains.Recipe;

@RequestScoped
public class ServiceRecipe {
	@Inject private RepoRecipeDao dao;

	public Recipe getRandomDefaultRecipe() {
		return dao.getRandomDefaultRecipe();
	}
	
}
