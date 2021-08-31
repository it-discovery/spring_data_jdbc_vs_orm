package it.discovery.jdbc.repository;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import it.discovery.jdbc.model.Product;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SpringJdbcProductRepository implements ProductRepository {
	
	private static final String INSERT_SQL = "INSERT INTO Products(name,price,created_at, updated_at) VALUES(?,?,?,?,?)";
	
	private static final String SELECT_SQL = "SELECT * FROM Products";
	
	private final DataSource dataSource;

	@Override
	public void save(Product product) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).usingGeneratedKeyColumns("id").withTableName("products");
	    int id = (int) jdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(product));
	    product.setId(id);
	}

	@Override
	public Product findById(int id) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject(SELECT_SQL, new ProductMapper());
	}

}
