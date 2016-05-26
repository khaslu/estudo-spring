package br.com.khaslu.uploadingfiles;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The Class Main.
 *
 * @author Lucas Mota Vieira
 * @since 26/05/2016
 */
@SpringBootApplication
public class Main {

	/** The Constant ROOT. */
	public final static String ROOT = "upload-dir";

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		SpringApplication.run(Main.class, args);
	}

	/**
	 * Inits the.
	 *
	 * @return the command line runner
	 */
	@Bean
	CommandLineRunner init() {
		return (final String[] args) -> {
			new File(Main.ROOT).mkdir();
		};
	}

}
