package ru.miroque.fastcook.dto;

import lombok.Data;
import ru.miroque.fastcook.domains.Dish;

@Data
public class DaoMenuItemOrder {
	private final Integer id;
	private final Dish dish;
	private final Boolean order;
}
