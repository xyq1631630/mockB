package com.mockbackend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mockbackend.dao.FoodDAO;
import com.mockbackend.dao.OrderDAO;
import com.mockbackend.entity.Food_Quantity;
import com.mockbackend.entity.RestaurantFood;
import com.mockbackend.entity.RestaurantOrder;
import com.mockbackend.response.Response;

@Service
//@Transactional(readOnly = false)
public class RestaurantService {
	
	@Autowired
	OrderDAO rO;
	
	@Autowired
	FoodDAO rF;

	public List<RestaurantFood> allFood() {
		return rF.findAll();
	}
	
	public List<RestaurantOrder> getAllOrder() {
		return rO.findAll();
	}
	
//	public restaurantFood getOneFood(Integer food_id) {
//		return rF.findByFood_id(food_id);
//	}
	
	public Map<String, Integer> addOrder(RestaurantOrder rOrder) {
		//return JSON format
		Map<String, Integer> result = new HashMap<>();
		
		//Calculate the total price of this order
		Integer totalPrice = 0;
		List<Food_Quantity> ls = rOrder.getFood_quantity();
		for(Food_Quantity fq : ls) {
			Integer temp = fq.getCount() * fq.getFood().getFoodprice();
			totalPrice += temp;
		}
		result.put("total",totalPrice);
		result.put("tableid", rOrder.getTableid());
		
		//Add to database
		Integer tempId = rO.findTopId();
		if(tempId == null) tempId = 0;
		rOrder.setOrderid(++tempId);
		rOrder.getFood_quantity().forEach(food_quantity -> food_quantity.setOrder(rOrder));
		rO.save(rOrder);
		
		return result;
	}
	
	public RestaurantOrder getOne(int orderid) {
		return rO.findByOrderid(orderid);
	}
	
	public Map<String, Integer> getPrice(int tableid) {
		Map<String, Integer> result = new HashMap<>();
		RestaurantOrder tempOrder = rO.findByTableid(tableid);
		
		Integer totalPrice = 0;
		List<Food_Quantity> ls = tempOrder.getFood_quantity();
		for(Food_Quantity fq : ls) {
			Integer temp = fq.getCount() * fq.getFood().getFoodprice();
			totalPrice += temp;
		}
		
		result.put("total", totalPrice);
		result.put("tableid", tempOrder.getTableid());
		
		return result;
	}
}
