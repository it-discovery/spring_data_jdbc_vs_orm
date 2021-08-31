package it.discovery.jdbc.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter @Setter
public abstract class BaseEntity {

	@CreatedDate
	private LocalDateTime created;

	@LastModifiedDate
	private LocalDateTime modified;
}
