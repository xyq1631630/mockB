package com.mockbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockbackend.dao.restaurantDao;
import com.mockbackend.entity.restaurantFood;
import com.mockbackend.entity.restaurantOrder;
import com.mockbackend.response.Response;

@Service
public class restaurantService {
	
	@Autowired
	restaurantDao rDao;

	public List<restaurantFood> allFood() {
		return rDao.foodList;
	}
	
	public List<restaurantOrder> getAllOrder() {
		return rDao.orderList;
	}
	
	public Response addOrder(restaurantOrder rOrder) {
		restaurantOrder newOrder = new restaurantOrder(0, rOrder.getPrice());
		
		if (rDao.orderList.size() != 0) {
			int oid = rDao.orderList.get(rDao.orderList.size() - 1).getId() + 1;
			newOrder.setId(oid);
		}
		
		rDao.orderList.add(newOrder);
		
		return new Response(true, "Add order successfully");
	}
}
