package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {


	@Autowired
	private MenuItemDao dao;
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		return dao.getMenuItemListCustomer();
	}
	
	public MenuItem getMenuItem(long menuItemId)
	{
		return dao.getMenuItem(menuItemId);	
	}
	
	public void modifyMenuItem(MenuItem menuItem)
	{
		dao.modifyMenuItem(menuItem);
	}
}
