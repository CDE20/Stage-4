package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component("cartDao")
public class CartDaoCollectionImpl implements CartDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);
	
	private HashMap<String, Cart> userCarts;

	public CartDaoCollectionImpl() {
		userCarts = new HashMap<>();
	}
	
	@Autowired
	private MenuItemDao menuItemDao;

	@Override
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {

		LOGGER.info("Start");
		
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			List<MenuItem> menuItemList = new ArrayList<>();
			Cart cart = new Cart(menuItemList, 0);
			menuItemList.add(menuItem);
			userCarts.put(userId, cart);
		}
		
		LOGGER.debug("userCarts : {}", userCarts);
		LOGGER.info("End");
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		Cart cart = userCarts.getOrDefault(userId, new Cart(new ArrayList<MenuItem>(), 0));

		List<MenuItem> menuItemList = cart.getMenuItemList();

		if (menuItemList.isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		} else {
			double total = 0;
			for (MenuItem m : menuItemList) {
				total += m.getPrice();
			}
			cart.setTotal(total);
			userCarts.put(userId, cart);
		}
		return menuItemList;
	}

	@Override
	public void deleteCartItem(String userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		if (cart != null) {
			List<MenuItem> menuItemList = cart.getMenuItemList();
			for (int i = 0; i < menuItemList.size(); i++) {
				if (menuItemList.get(i).getId() == menuItemId) {
					menuItemList.remove(i);
				}
			}
		}
	}

}
