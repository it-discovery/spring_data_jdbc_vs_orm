package it.discovery.jdbc.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product extends BaseEntity {
	
	private int id;
	
	private String name;

	private Set<Order> orders;

	private double price;
	
	private Integer version;

	public void addOrder(Order order) {
		if(orders == null) {
			orders = new HashSet<>();
		}
		orders.add(order);
	}
}
