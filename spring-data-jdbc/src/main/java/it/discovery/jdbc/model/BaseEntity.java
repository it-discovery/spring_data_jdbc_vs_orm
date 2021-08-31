package it.discovery.jdbc.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class BaseEntity {
	
	private LocalDateTime created;

	private LocalDateTime modified;
}
