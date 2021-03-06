package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;

@Repository
@ImportResource("truyum.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);
	
	@Autowired
	private List<MenuItem> menuItemList;

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("Start");

		ArrayList<MenuItem> menuItems = new ArrayList<>();
		Date currentDate = new Date();
		for (MenuItem mi : menuItemList) {
			if (mi.getDateOfLaunch().compareTo(currentDate) <= 0) {
				if (mi.isActive())
					menuItems.add(mi);
			}
		}

		LOGGER.info("End");
		return menuItems;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("Start");
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.remove(i);
				menuItemList.add(i, menuItem);
			}
		}
		LOGGER.info("End");
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws MenuItemNotFoundException {
		LOGGER.info("Start");
		
		boolean got = false;
		for (MenuItem m : menuItemList) {
			if (m.getId() == menuItemId) {
				got = true;
				return m;
			}
		}
		if (!got) throw new MenuItemNotFoundException("Menu Item Not Found");
		
		LOGGER.info("End");
		return null;
	}

}
