package ru.miroque.fastcook.domains;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Cook {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private List<Recipe> canDo;
}
