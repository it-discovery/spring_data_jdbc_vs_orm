package it.discovery.jdbc.service;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;

import it.discovery.jdbc.config.JdbcConfig;

@JdbcTest
@ContextConfiguration(classes=JdbcConfig.class)
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class ProductServiceTest {

}
