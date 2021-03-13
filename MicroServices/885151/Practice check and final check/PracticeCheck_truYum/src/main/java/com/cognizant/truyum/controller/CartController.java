package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);


	@Autowired
	CartService service;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId,@PathVariable long menuItemId)
	{
		LOGGER.info("start addCartItem");
		service.addCartItem(userId, menuItemId);
		LOGGER.info("end addCartItem");
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException
	{
		LOGGER.info("start getAllCartItems");
		List<MenuItem> list=service.getAllCartItems(userId);
		LOGGER.info("end getAllCartItems");
		return list;
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable String userId,@PathVariable long menuItemId)
	{
		LOGGER.info("start removeCartItem");
		service.removeCartItem(userId, menuItemId);
		LOGGER.info("end removeCartItem");
	}
}
