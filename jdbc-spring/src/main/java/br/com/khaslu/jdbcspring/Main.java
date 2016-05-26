package br.com.khaslu.jdbcspring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import br.com.khaslu.jdbcspring.model.Customer;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(final String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(final String... arg0) throws Exception {

		this.logger.info("[BEGIN] run");
		this.logger.info("Criando datasource");
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql://localhost/jdbc-spring?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		final JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		this.logger.info("Criando tabelas");
		jdbcTemplate.execute("drop table if exists customer");
		jdbcTemplate.execute("create table customer (" + "id bigint primary key auto_increment"
				+ ",firstName varchar(255)" + ",lastName varchar(255)" + ")");
		final List<Object[]> splitUpNames = Arrays
				.asList("Lucas Mota", "Murilo Mota", "Arthur Mota", "Catharina Mota", "Isabela Mota").stream()
				.map(s -> s.split(" ")).collect(Collectors.toList());
		splitUpNames
				.forEach(name -> this.logger.info(String.format("Inserting customer record for %s %s", name[0], name[1])));
		jdbcTemplate.batchUpdate("Insert into customer (firstName, lastName) values (?,?)", splitUpNames);
		this.logger.info("Localizando Murilo");
		jdbcTemplate
				.query("select id, firstName, lastName from customer where firstName = ?",
						new Object[] { "Murilo" }, (row, rowNum) -> new Customer(row.getLong("id"),
								row.getString("firstName"), row.getString("lastName")))
				.forEach(c -> this.logger.info(c.toString()));
		this.logger.info("[END] run");
	}
}
