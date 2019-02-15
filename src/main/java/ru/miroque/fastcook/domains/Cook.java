package ru.miroque.fastcook.domains;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
public class Cook {
	@Getter @Setter
	private String name;
	@Getter @Setter
	private List<Recipe> canDo;
}
