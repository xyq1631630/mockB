package com.mockbackend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mockbackend.entity.RestaurantFood;
import com.mockbackend.entity.RestaurantOrder;
import com.mockbackend.response.Response;
import com.mockbackend.service.RestaurantService;

@CrossOrigin("*")
//@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If-Match")
@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantService rService;
	
	@GetMapping("/food")
	public List<RestaurantFood> allFood() {
		return rService.allFood();
	}
	
//	@GetMapping("/food/{food_id}")
//	public restaurantFood oneFood(@PathVariable Integer food_id) {
//		return rService.getOneFood(food_id);
//	}
	
	@GetMapping("/order")
	public List<RestaurantOrder> getAllOrder() {
		return rService.getAllOrder();
	}

	@PostMapping("/addNewOrder")
	public Map<String, Integer> addOrder(@RequestBody RestaurantOrder rOrder) {
		return rService.addOrder(rOrder);
	}
	
	@GetMapping("/order/{orderid}")
	public RestaurantOrder getOrder(@PathVariable int orderid) {
		return rService.getOne(orderid);
	}
	
	@GetMapping("/getPrice/{tableid}")
	public Map<String, Integer> getPrice(@PathVariable int tableid) {
		return rService.getPrice(tableid);
	}
}
