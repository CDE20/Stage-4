package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
@Service
public class MenuItemDaoSerivce {
	
	@Autowired
	MenuItemDao  dao;
	
	public List<MenuItem> getAllMenuItems(){
		return dao.getMenuItemListAdmin();
		
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return dao.getMenuItemListCustomer();
	}

	public MenuItem getMenuItemId(int id) {
		return dao.getMenuItem(id);
	}
	
	public MenuItem saveMenuItem(MenuItem menuItem) {
		dao.saveMenuItem(menuItem);
		return menuItem;
	}

}
