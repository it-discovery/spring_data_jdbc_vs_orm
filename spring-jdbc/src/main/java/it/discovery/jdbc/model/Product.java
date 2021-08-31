package it.discovery.jdbc.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private int id;

	private String name;
	
	private double price;

	private List<Order> orders;

	public void addOrder(Order order) {
		if (orders == null) {
			orders = new ArrayList<>();
		}
		orders.add(order);
	}

	private LocalDateTime createdAt;
	
	private LocalDateTime modifiedAt;
	
}
