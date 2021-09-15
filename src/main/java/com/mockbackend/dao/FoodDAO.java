package com.mockbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mockbackend.entity.RestaurantFood;

public interface FoodDAO extends JpaRepository<RestaurantFood, Integer> {
	
//	restaurantFood findByFood_id(int food_id);
	
	public List<RestaurantFood> findAll();
	
	
}
