package ru.miroque.fastcook.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Dish {
	@Getter @Setter
	private Recipe recipe;
	@Getter @Setter
	private Double price;
}
