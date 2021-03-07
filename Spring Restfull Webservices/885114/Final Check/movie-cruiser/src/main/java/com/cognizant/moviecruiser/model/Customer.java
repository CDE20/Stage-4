package com.cognizant.moviecruiser.model;

import java.util.List;

public class Customer {

	private int id;
	private String name;
	private List<Movie> favorites;
	private int totalFavoriteCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Movie> favorites) {
		this.favorites = favorites;
	}

	public int getTotalFavoriteCount() {
		return totalFavoriteCount;
	}

	public void setTotalFavoriteCount(int totalFavoriteCount) {
		this.totalFavoriteCount = totalFavoriteCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", favorites=" + favorites + ", totalFavoriteCount="
				+ totalFavoriteCount + "]";
	}

}
