package ru.miroque.fastcook.domains;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@SuppressWarnings("serial")
public class Dish implements Serializable{
	@Getter @Setter
	private Integer id;
	@Getter @Setter
	private Recipe recipe;
	@Getter @Setter
	private Double price;
}
