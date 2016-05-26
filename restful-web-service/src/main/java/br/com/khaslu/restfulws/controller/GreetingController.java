package br.com.khaslu.restfulws.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.khaslu.restfulws.model.Greeting;

/**
 * The Class GreetingController.
 *
 * @author Lucas Mota Vieira
 * @since 24/05/2016
 */
@RestController
public class GreetingController {

	/** The Constant template. */
	private static final String template = "Hello, %s!";

	/** The counter. */
	private final AtomicLong counter = new AtomicLong();

	/**
	 * Greeting.
	 *
	 * @param name
	 *           the name
	 * @return the greeting
	 */
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") final String name) {

		return new Greeting(this.counter.incrementAndGet(), String.format(GreetingController.template, name));
	}
}
