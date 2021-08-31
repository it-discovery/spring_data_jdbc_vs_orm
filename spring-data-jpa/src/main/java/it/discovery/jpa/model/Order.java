package it.discovery.jpa.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@Table(name = "ORDERS")
@Entity
@NoArgsConstructor
public class Order extends BaseEntity {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private int amount;

	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public Order(int amount, Product product) {
		this.amount = amount;
		this.product = product;
	}
}
