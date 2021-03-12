package com.cognizant.truYum1.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truYum1.model.MenuItem;

@Component
public class MenuItemDao {
	private ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();

	public MenuItemDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("truYum.xml");
		this.menuItemList = (ArrayList<MenuItem>) context.getBean("menuItemList");
	}

	public MenuItem getMenuItem(int id) {
		for (MenuItem m : menuItemList) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	public void modifyMenuItem(int id, MenuItem m) {
		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menu = menuItemList.get(i);
			if (menu.getId() == id) {
				menuItemList.set(i, m);
			}
		}
	}
}
