package ru.miroque.fastcook.controllers;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import lombok.Getter;
import lombok.Setter;
import ru.miroque.fastcook.dto.DaoMenuItemOrder;
import ru.miroque.fastcook.services.ServiceDish;

@Named
@ViewScoped
public class MenuController implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(getClass());

	@Getter @Setter
	private List<DaoMenuItemOrder> menu;

	@Inject
	private ServiceDish serviceDish;

	@PostConstruct
	private void initMenu() {
		menu = serviceDish.getDefaultListOfDishes().stream().map(i -> new DaoMenuItemOrder(i, Boolean.FALSE))
				.collect(Collectors.toList());
		log.info("POST CONSTRUCT menu size " + menu.size());
	}

	public String makeOrder() {
		log.info("this dishes ordered: ");
		menu.stream().filter(i -> i.getOrder()).forEach(i -> log.info("   " + i.getDish().getRecipe().getName()));
		return "";
	}

}
