package com.mockbackend.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mockbackend.entity.restaurantFood;
import com.mockbackend.entity.restaurantOrder;

@Repository
public class restaurantDao {
	
	public static List<restaurantFood> foodList = new ArrayList<>();
	
	public static List<restaurantOrder> orderList = new ArrayList<>();
	
	static {
		foodList.add(new restaurantFood(0, "Chicken", 5));
		foodList.add(new restaurantFood(1, "Shrimp", 7));
		foodList.add(new restaurantFood(2, "Pizza", 8));
		foodList.add(new restaurantFood(3, "Pasta", 10));
		foodList.add(new restaurantFood(4, "Burger", 4));
		foodList.add(new restaurantFood(5, "Steak", 6));
		foodList.add(new restaurantFood(6, "Noddle", 5));
		foodList.add(new restaurantFood(7, "Tea", 2));
		foodList.add(new restaurantFood(8, "Coffee", 3));
		foodList.add(new restaurantFood(9, "Ice Cream", 2));
	};

}
