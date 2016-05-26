package br.com.khaslu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The Class Main.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
@SpringBootApplication
@EnableScheduling
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *           the arguments
	 */
	public static void main(final String[] args) {

		SpringApplication.run(Main.class, args);
	}
}
