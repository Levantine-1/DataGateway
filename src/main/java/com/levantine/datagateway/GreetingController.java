package com.levantine.datagateway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(String.format(template, name));
	}

	@GetMapping("/mousey")
	public Greeting mousey(@RequestParam(value = "name", defaultValue = "Mousey") String name) {
		return new Greeting(String.format(template, name));
	}

	@Autowired
	private TokenRepository tokenRepository;

	@GetMapping("/tokens")
	public Iterable<auth_token> getTokens() {
		return tokenRepository.findAll();
	}
}
