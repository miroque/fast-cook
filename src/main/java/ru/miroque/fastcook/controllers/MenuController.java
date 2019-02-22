package ru.miroque.fastcook.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.jboss.logging.Logger;

import lombok.Getter;
import lombok.Setter;
import ru.miroque.fastcook.domains.Dish;
import ru.miroque.fastcook.dto.DaoMenuItemOrder;
import ru.miroque.fastcook.services.ServiceDish;

@Named
@ViewScoped
public class MenuController implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Logger log = Logger.getLogger(getClass());

	@Getter @Setter
	private List<Dish> menu;

	@Getter @Setter
	private List<Dish> selected;

	@Inject
	private ServiceDish serviceDish;

	@PostConstruct
	private void initMenu() {
		log.info("initMenu <-");
		menu = serviceDish.getDefaultListOfDishes();
		log.info("::menu size: " + menu.size());
		selected = new ArrayList<>();
		for (Dish item : selected) {
			log.info("::selected:item " + item);
		}
		log.info("initMenu ->");
	}

	public void makeOrder() {
		log.info("makeOrder <-");
		for (Dish item : selected) {
			log.info("::selected:item " + item);
		}
		log.info("makeOrder ->");
	}

}
