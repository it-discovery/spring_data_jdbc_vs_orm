package it.discovery.jdbc.model;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
	
	private UUID id;
	
	private int product;
	
	private int amount;
	
	private LocalDate createdAt;

}
