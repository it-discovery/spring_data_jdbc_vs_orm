package it.discovery.jdbc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import it.discovery.jdbc.repository.ProductRepository;
import it.discovery.jdbc.repository.SpringJdbcProductRepository;

@Configuration
@ComponentScan(basePackages = "it.discovery")
public class JdbcConfig {

	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.H2)
				.addScript("dbinit.sql")
				.build();
	}
	
	@Bean
	public ProductRepository productRepository() {
		return new SpringJdbcProductRepository(dataSource());
	}
}
