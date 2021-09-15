package com.mockbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "food_quantity")
public class Food_Quantity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
	@SequenceGenerator(name = "SEQ", sequenceName = "FQ_SEQ")
	private Integer foodquantityid;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = (CascadeType.ALL))
	@JoinColumn(name = "orderid")
	private RestaurantOrder order;
	
	@ManyToOne
	@JoinColumn(name = "foodid")
	private RestaurantFood food;
	
	@Column(name = "count")
	private Integer count;

	public Food_Quantity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Food_Quantity(Integer foodquantityid, RestaurantOrder order, RestaurantFood food, Integer count) {
		super();
		this.foodquantityid = foodquantityid;
		this.order = order;
		this.food = food;
		this.count = count;
	}

	public Integer getFoodquantityid() {
		return foodquantityid;
	}

	public void setFoodquantityid(Integer foodquantityid) {
		this.foodquantityid = foodquantityid;
	}

	public RestaurantOrder getOrder() {
		return order;
	}

	public void setOrder(RestaurantOrder order) {
		this.order = order;
	}

	public RestaurantFood getFood() {
		return food;
	}

	public void setFood(RestaurantFood food) {
		this.food = food;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "restaurantQuantity [foodquantityid=" + foodquantityid + ", order=" + order + ", food=" + food
				+ ", count=" + count + "]";
	}
}
