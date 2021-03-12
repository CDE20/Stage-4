package com.cognizant.truYum1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truYum1.dao.MenuItemDao;
import com.cognizant.truYum1.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;

	public MenuItem getMenuItem(int id) {
		return menuItemDao.getMenuItem(id);
	}

	public void modifyMenuItem(int id, MenuItem menu) {
		menuItemDao.modifyMenuItem(id, menu);
	}
}
