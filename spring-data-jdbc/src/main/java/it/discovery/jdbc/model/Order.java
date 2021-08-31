package it.discovery.jdbc.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter @Setter
@Table("ORDERS")
public class Order extends BaseEntity {

	@Id
	private UUID id;
	
	private int amount;

	private int product;

	public Order() {
	}

	public Order(int amount, int product) {
		this.amount = amount;
		this.product = product;
	}
}
