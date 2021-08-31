package it.discovery.jpa.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity {
	
	@CreationTimestamp
	private LocalDateTime created;

	@UpdateTimestamp
	private LocalDateTime modified;
}
