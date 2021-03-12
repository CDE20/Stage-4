package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;

	List<MenuItem> getAllCartItems(String userId) throws CartEmptyException;

	void deleteCartItem(String userId, long menuItemId);
}
