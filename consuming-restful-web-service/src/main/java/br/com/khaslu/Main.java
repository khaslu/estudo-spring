package br.com.khaslu;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import br.com.khaslu.model.Quote;

@SpringBootApplication
public class Main implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(final String[] args) {

		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(final String... arg0) throws Exception {

		final RestTemplate restTemplate = new RestTemplate();
		final Long inicio = System.currentTimeMillis();
		final Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		final Long fim = System.currentTimeMillis();
		Main.log.info(quote.toString());
		Main.log.info("Duração: " + DurationFormatUtils.formatDuration(fim - inicio, "dd HH:mm:ss.SSS"));
	}
}
