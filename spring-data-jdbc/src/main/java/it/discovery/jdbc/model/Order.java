package it.discovery.jdbc.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order extends BaseEntity {
	
	private UUID id;
	
	private int amount;

	private Product product;

	public Order(int amount, Product product) {
		this.amount = amount;
		this.product = product;
	}
}
