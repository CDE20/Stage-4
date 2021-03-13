package com.cognizant.truyum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemDaoSerivce;

@RestController
public class MenuItemController {
	
	@Autowired
	MenuItemDaoSerivce service;
	
	
	@GetMapping("/menu-items")
	public List<MenuItem> getAllMenuItem(){
		return service.getMenuItemListCustomer();
	}
	
	@GetMapping("/menu-items/{id}")
	public MenuItem getAllMenuItem(@PathVariable int id) throws MenuItemNotFoundException{
		MenuItem item = service.getMenuItemId(id);
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
		MenuItem upadtedmenu = service.getMenuItemId(id);
		if(upadtedmenu==null) {
			throw new MenuItemNotFoundException("Menu Item not Found");
		}
		//upadtedmenu.setId(menuItem.getId());
		upadtedmenu.setName(menuItem.getName());
		upadtedmenu.setCategory(menuItem.getCategory());
		upadtedmenu.setPrice(menuItem.getPrice());
		upadtedmenu.setActive(menuItem.isActive());
		upadtedmenu.setDateOfLaunch(menuItem.getDateOfLaunch());
		upadtedmenu.setFreeDelivery(menuItem.isFreeDelivery());
		return upadtedmenu;
	}

}
