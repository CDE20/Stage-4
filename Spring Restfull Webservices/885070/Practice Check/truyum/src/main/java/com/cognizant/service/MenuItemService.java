package com.cognizant.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.MenuItem;
import com.cognizant.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	private MenuItemRepository menuItemRepository;
	
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemRepository.findByActiveAndDateOfLaunchBefore("Yes", new Date());
	}
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemRepository.findAll();
	}
	
	@Transactional
	public MenuItem getMenuItem(int id) {
		return menuItemRepository.findById(id).get();
	}
	
	@Transactional
	public void modifyMenuItem(int id, MenuItem menuItem) {
		MenuItem toupdate = menuItemRepository.findById(id).get();
		menuItem.setId(toupdate.getId());
		menuItemRepository.save(menuItem);
	}

}