package com.cognizant.truYum1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truYum1.model.MenuItem;
import com.cognizant.truYum1.service.MenuItemService;

//import com.example.model.Employee;
@RestController
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping("/menu/{id}")
	public MenuItem getMenuItem(@PathVariable int id) {
		return menuItemService.getMenuItem(id);
	}

	@PutMapping("/menuitem/{id}")
	public void modifyMenuItem(@RequestBody MenuItem menu, @PathVariable int id) {
		menuItemService.modifyMenuItem(id, menu);
	}
}
