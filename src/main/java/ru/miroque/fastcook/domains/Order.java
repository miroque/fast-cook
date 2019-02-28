package ru.miroque.fastcook.domains;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@EqualsAndHashCode
@ToString
public class Order implements Serializable{
	
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
