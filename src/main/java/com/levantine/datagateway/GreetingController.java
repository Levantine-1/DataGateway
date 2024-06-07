package com.levantine.datagateway;

import com.levantine.datagateway.PerconaCluster.TokenRepository;
import com.levantine.datagateway.PerconaCluster.TokenRequest;
import com.levantine.datagateway.PerconaCluster.auth_token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.server.ResponseStatusException;

import java.security.NoSuchAlgorithmException;


@RestController
public class GreetingController {
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

	@GetMapping("/mousey")
	public Greeting mousey(@RequestParam(value = "name", defaultValue = "Mousey") String name) {
		return new Greeting(String.format(name));
	}

	@Autowired
	private TokenRepository tokenRepository;

	@GetMapping("/tokens")
	public Iterable<auth_token> getTokens() {
		return tokenRepository.findAll();
	}

	@PostMapping("/generateToken")
	public String generateToken(@RequestBody TokenRequest request) throws NoSuchAlgorithmException {
		String email = request.getEmail();
		String token = auth_token.generateToken(email);
		auth_token authToken = new auth_token();
		authToken.setTokenHash(token);
		authToken.setCreatedDate(new java.util.Date());
		authToken.setLastAccessed(new java.util.Date());
		tokenRepository.save(authToken);
		logger.info("Email: " + email); // This is just for a demo, the email is not stored or used anywhere for now.
		return token;
	}
}
