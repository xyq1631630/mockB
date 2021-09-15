package com.mockbackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mockbackend.entity.RestaurantOrder;

public interface OrderDAO extends JpaRepository<RestaurantOrder, Integer>{
	
	public List<RestaurantOrder> findAll();
	
	RestaurantOrder findByOrderid(int orderid);
	
	@Query(value = "SELECT MAX(ORDERID) FROM ORDERS", nativeQuery = true)
	public Integer findTopId();
	
	@Query(value = "SELECT * FROM ORDERS WHERE ORDERID = :id", nativeQuery = true)
	public RestaurantOrder findID(int id);
	
	RestaurantOrder findByTableid(int tableid);
}
