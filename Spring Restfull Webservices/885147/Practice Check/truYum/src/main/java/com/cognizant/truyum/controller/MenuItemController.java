package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
public class MenuItemController {

	@Autowired
	private MenuItemService service;

	@GetMapping("/menu-items")
	public List<MenuItem> getAllMenuItem(){
		return service.getMenuItemListCustomer();
	}
	
	@GetMapping("/menu-items/{id}")
	public MenuItem getAllMenuItem(@PathVariable int id) throws MenuItemNotFoundException{
		MenuItem item = service.getMenuItem(id);
		if(item==null) {
			throw new MenuItemNotFoundException("Menu Item not Found");
		}
		return item;
	}
	
	@PostMapping("/menu-items")
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return service.saveMenuItem(menuItem);
	}
	
	@PutMapping("/menu-items/modify/{id}")
	public MenuItem modifyMenuItem(@PathVariable int id,@RequestBody MenuItem menuItem) throws MenuItemNotFoundException {
		MenuItem updatedmenu = service.getMenuItem(id);
		if(updatedmenu==null) {
			throw new MenuItemNotFoundException("Menu Item not Found");
		}
		updatedmenu.setName(menuItem.getName());
		updatedmenu.setCategory(menuItem.getCategory());
		updatedmenu.setPrice(menuItem.getPrice());
		updatedmenu.setActive(menuItem.isActive());
		updatedmenu.setDateOfLaunch(menuItem.getDateOfLaunch());
		updatedmenu.setFreeDelivery(menuItem.isFreeDelivery());
		return updatedmenu;
	}

}