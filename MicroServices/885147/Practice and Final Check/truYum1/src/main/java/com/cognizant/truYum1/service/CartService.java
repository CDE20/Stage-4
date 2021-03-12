package com.cognizant.truYum1.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truYum1.dao.CartItemDao;
import com.cognizant.truYum1.model.MenuItem;

@Service
public class CartService {
	@Autowired
	private CartItemDao cartDao;

	public void addCartItem(String user, int menu) {
		cartDao.addCartItem(user, menu);
	}

	public ArrayList<MenuItem> getAllCartItems(String userid) {
		return cartDao.getAllCartItems(userid);
	}

	public void deleteCartItem(String uid, int mid) {
		cartDao.deleteCartItem(uid, mid);
	}
}
