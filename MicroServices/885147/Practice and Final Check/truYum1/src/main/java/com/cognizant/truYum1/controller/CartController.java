package com.cognizant.truYum1.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truYum1.model.MenuItem;
import com.cognizant.truYum1.service.CartService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/{userid}/{menuItemId}")
	public void addCartItem(@PathVariable String userid, @PathVariable int menuItemId) {
		cartService.addCartItem(userid, menuItemId);
	}

	@GetMapping("/carts/{userid}")
	public ArrayList<MenuItem> getAllCartItem(@PathVariable String userid) {
		return cartService.getAllCartItems(userid);
	}

	@DeleteMapping("/{userid}/{menuItemId}")
	public void deleteAllCartItem(@PathVariable String userid, @PathVariable int menuItemId) {
		cartService.deleteCartItem(userid, menuItemId);
	}
}
