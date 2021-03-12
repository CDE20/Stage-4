package com.cognizant.truYum1.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private String name;
	private MenuItem menuitem;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MenuItem getMenuitem() {
		return menuitem;
	}

	public void setMenuitem(MenuItem menuitem) {
		this.menuitem = menuitem;
	}

	@Override
	public String toString() {
		return "Cart [name=" + name + ", menuitem=" + menuitem + "]";
	}

}
