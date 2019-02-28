package ru.miroque.fastcook.domains;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@SuppressWarnings("serial")
public class Recipe implements Serializable{
	@Getter @Setter
	private String name;
	
	@Getter @Setter
	private List<CookStep> steps;

	public Recipe() {
		this.name = "NA";
		this.steps = Collections.emptyList();
	}

	public Recipe(String name, List<CookStep> steps) {
		this.name = name;
		this.steps = steps;
	}

}
