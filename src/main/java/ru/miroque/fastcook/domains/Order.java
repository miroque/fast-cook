package ru.miroque.fastcook.domains;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Order {
	
	@Getter
	@Setter
	private Integer number;
	
	@Getter
	@Setter
	private List<Dish> items;

	public Boolean complete() {
		return Boolean.FALSE;
	};
	
	public Double sum() {
		return items.stream().mapToDouble(dish -> dish.getPrice()).sum();
	};
}
