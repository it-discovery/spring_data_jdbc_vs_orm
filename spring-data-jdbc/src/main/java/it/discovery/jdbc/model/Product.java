package it.discovery.jdbc.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter

@Table("PRODUCTS")
public class Product extends BaseEntity {

	@Id
	private int id;
	
	private String name;

	@MappedCollection(idColumn = "product", keyColumn = "product")
	private Set<Order> orders;

	private double price;

	@Version
	private Integer version;

	public void addOrder(Order order) {
		if(orders == null) {
			orders = new HashSet<>();
		}
		orders.add(order);
	}
}
