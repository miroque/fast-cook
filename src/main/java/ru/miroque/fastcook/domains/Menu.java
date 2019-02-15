package ru.miroque.fastcook.domains;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Menu{
	@Getter
	private List<Dish> items;
	
	
}