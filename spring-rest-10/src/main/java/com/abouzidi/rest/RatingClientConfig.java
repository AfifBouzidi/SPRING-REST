package com.abouzidi.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RatingClientConfig {

	@Bean
	RestTemplate restTemplate() {
		ResourceOwnerPasswordResourceDetails resourceDetails = new
				ResourceOwnerPasswordResourceDetails();
				resourceDetails.setGrantType("password");
				resourceDetails.setAccessTokenUri("http://localhost:8080/oauth/token");
				resourceDetails.setClientId("ratingBookClient");
				resourceDetails.setClientSecret("top_secret");
				List<String> scopes = new ArrayList<>();
				scopes.add("read"); 
				scopes.add("write");
				resourceDetails.setScope(scopes);
				resourceDetails.setUsername("admin");
				resourceDetails.setPassword("test");
				return new OAuth2RestTemplate(resourceDetails);
	}

}
