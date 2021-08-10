package com.mockbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mockbackend.entity.restaurantFood;
import com.mockbackend.entity.restaurantOrder;
import com.mockbackend.response.Response;
import com.mockbackend.service.restaurantService;

@CrossOrigin("*")
//@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If-Match")
@RestController
public class restaurantController {
	
	@Autowired
	restaurantService rService;
	
	@GetMapping("/food")
	public List<restaurantFood> allFood() {
		return rService.allFood();
	}
	
	@GetMapping("/order")
	public List<restaurantOrder> getAllOrder() {
		return rService.getAllOrder();
	}

	@PostMapping("/addNewOrder")
	public Response addOrder(@RequestBody restaurantOrder rOrder) {
		return rService.addOrder(rOrder);
	}
}
