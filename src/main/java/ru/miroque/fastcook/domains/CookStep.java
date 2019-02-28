package ru.miroque.fastcook.domains;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@SuppressWarnings("serial")
public class CookStep implements Serializable{
	@Getter @Setter
	private String name;
	@Getter @Setter
	private Integer time;
	@Getter @Setter
	private Boolean doing;

	public CookStep() {
		name = "NA";
		time = 0;
		doing = Boolean.FALSE;
	}

	public CookStep(String name, Integer time, Boolean doing) {
		this.name = name;
		this.time = time;
		this.doing = doing;
	}
}
