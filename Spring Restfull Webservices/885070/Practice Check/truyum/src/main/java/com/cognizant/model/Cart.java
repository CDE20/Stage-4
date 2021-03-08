package com.cognizant.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Cart {

	@Id
	@Column(name = "ct_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ct_us_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "ct_pr_id")
	private MenuItem menuItem;

	@OneToMany(mappedBy = "cart")
	private Set<MenuItem> menuItemList;
	private BigDecimal total;

	public Cart(HashSet<MenuItem> menuItemList, BigDecimal total) {
		// TODO Auto-generated constructor stub
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MenuItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
	}

	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", menuItem=" + menuItem + "]";
	}

}