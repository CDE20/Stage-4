package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService service;
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllMenuItem(@PathVariable String userId) throws CartEmptyException{
		return service.getAllMenuItems(userId);
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId,@PathVariable int menuItemId) {
		service.addCartItem(userId, menuItemId);
		
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId,@PathVariable int menuItemId) {
		service.deleteCartItem(userId, menuItemId);
		
	}
}
