package com.mockbackend.entity;

public class restaurantOrder {
	
	private int id;
	
	private int price;

	public restaurantOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public restaurantOrder(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public int getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "restaurantOrder [id=" + id + ", price=" + price + "]";
	}
}
