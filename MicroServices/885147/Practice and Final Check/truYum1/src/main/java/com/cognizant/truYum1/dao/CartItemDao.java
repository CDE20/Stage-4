package com.cognizant.truYum1.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truYum1.model.MenuItem;

@Component
public class CartItemDao {
	@Autowired
	private MenuItemDao menuitemDao;
	private Map<String, MenuItem> cartMap = new HashMap<String, MenuItem>();
	ArrayList<MenuItem> menulist = new ArrayList<MenuItem>();

	public CartItemDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("cart.xml");
		this.cartMap = (Map<String, MenuItem>) context.getBean("cartmap");
	}

	public void addCartItem(String userid, int menuid) {
		MenuItem menu = menuitemDao.getMenuItem(menuid);
		cartMap.put(userid, menu);
	}

	public ArrayList<MenuItem> getAllCartItems(String userid) {

		for (Map.Entry cmap : cartMap.entrySet()) {
			if (cmap.getKey().equals(userid)) {
				this.menulist.add((MenuItem) cmap.getValue());
			}
		}
		System.out.println(menulist);
		return this.menulist;
	}

	public void deleteCartItem(String userid, int menuid) {
		for (Map.Entry cmap : cartMap.entrySet()) {
			int f = 0;
			if (cmap.getKey().equals(userid)) {
				MenuItem mi = (MenuItem) cmap.getValue();
				if (mi.getId() == menuid) {
					cartMap.replace(userid, mi, null);
					f = 1;
					break;
				}

				if (f == 1)
					break;
			}

		}
		System.out.println(cartMap);
	}
}
