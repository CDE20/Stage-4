package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartService.class);
	
	@Autowired
	private CartDao cartDao;

	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		LOGGER.info("Start");
		
		cartDao.addCartItem(userId, menuItemId);
		
		LOGGER.info("End");
	}

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		return cartDao.getAllCartItems(userId);
	}

	public void deleteCartItem(String userId, long menuItemId) {
		cartDao.deleteCartItem(userId, menuItemId);
	}

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}

}
