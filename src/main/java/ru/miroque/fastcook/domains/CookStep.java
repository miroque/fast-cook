package ru.miroque.fastcook.domains;

import lombok.Getter;
import lombok.Setter;

public class CookStep {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private Integer time;
	@Getter @Setter
	private Boolean doing;
}
