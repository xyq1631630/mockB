package com.mockbackend.entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class RestaurantOrder {
	
	@Id
	@Column(name = "orderid")
	private Integer orderid;
	
	@Column(name = "tableid")
	private Integer tableid;
	
	@OneToMany(mappedBy = "order", cascade = (CascadeType.ALL))
//	@JoinColumn(name = "orderid", referencedColumnName = "orderid")
	private List<Food_Quantity> food_quantity = new ArrayList<>();

	public RestaurantOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantOrder(Integer orderid, Integer tableid, List<Food_Quantity> food_quantity) {
		super();
		this.orderid = orderid;
		this.tableid = tableid;
		this.food_quantity = food_quantity;
	}

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public Integer getTableid() {
		return tableid;
	}

	public void setTableid(Integer tableid) {
		this.tableid = tableid;
	}

	public List<Food_Quantity> getFood_quantity() {
		return food_quantity;
	}

	public void setFood_quantity(List<Food_Quantity> food_quantity) {
		this.food_quantity = food_quantity;
	}

	@Override
	public String toString() {
		return "restaurantOrder [orderid=" + orderid + ", tableid=" + tableid + ", food_quantity=" + food_quantity
				+ "]";
	}
}
