package it.discovery.jdbc.model;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter @Setter
@Table("orders")
public class Order extends BaseEntity {

	@Id
	private UUID id;
	
	private int amount;

	private int productId;

	public Order(int amount, int productId) {
		this.amount = amount;
		this.productId = productId;
	}
}
