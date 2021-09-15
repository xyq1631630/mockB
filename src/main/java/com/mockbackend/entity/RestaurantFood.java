package com.mockbackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "food")
public class RestaurantFood {
	
	@Id
	@Column(name = "foodid")
	private Integer foodid;
	
	@Column(name = "foodname")
	private String foodname;
	
	@Column(name = "foodprice")
	private Integer foodprice;
	
	public RestaurantFood() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestaurantFood(Integer foodid, String foodname, Integer foodprice) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.foodprice = foodprice;
	}

	public Integer getFoodid() {
		return foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Integer getFoodprice() {
		return foodprice;
	}

	public void setFoodprice(Integer foodprice) {
		this.foodprice = foodprice;
	}

	@Override
	public String toString() {
		return "restaurantFood [foodid=" + foodid + ", foodname=" + foodname + ", foodprice=" + foodprice + "]";
	}

	
}
