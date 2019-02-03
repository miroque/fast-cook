package ru.miroque.fastcook.domains;

import lombok.Getter;
import lombok.Setter;

public class Dish {
	@Getter @Setter
	private Recipe recipe;
	@Getter @Setter
	private Double price;
}
