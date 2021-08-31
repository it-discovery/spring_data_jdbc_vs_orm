package it.discovery.jdbc.config;

import it.discovery.jdbc.model.Order;
import it.discovery.jdbc.model.Product;
import it.discovery.jdbc.repository.ProductRepository;
import it.discovery.jdbc.service.ProductService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.mapping.event.BeforeSaveEvent;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;
import java.util.UUID;

@Configuration
@EnableJdbcRepositories("it.discovery.jdbc.repository")
@EnableJdbcAuditing
public class JdbcConfig extends AbstractJdbcConfiguration {

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("dbinit.sql")
                .build();
    }

    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

    @Bean
    public ApplicationListener<BeforeSaveEvent<?>> beforeSave() {
        return event -> {
            Object entity = event.getEntity();
            if (entity instanceof Order order && order.getId() == null) {
                order.setId(UUID.randomUUID());
            }
            if (entity instanceof Product product && product.getOrders() != null) {
                product.getOrders().forEach(order -> {
                    if(order.getId() == null) {
                        order.setId(UUID.randomUUID());
                    }
                });

            }
        };
    }

}
