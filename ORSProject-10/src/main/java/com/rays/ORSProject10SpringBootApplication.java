package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Main application class for ORS Project 10 Spring Boot application. Configures
 * CORS (Cross-Origin Resource Sharing) for frontend access.
 * 
 * @author Aniket Rajput
 */
@SpringBootApplication
public class ORSProject10SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ORSProject10SpringBootApplication.class, args);
	}

	/**
	 * Configures CORS settings to allow cross-origin requests from frontend
	 * applications. Allows requests from localhost:4200 (Angular dev server) and
	 * localhost.
	 * 
	 * @return WebMvcConfigurer with CORS configuration
	 */
	@Bean
	public WebMvcConfigurer corsConfig() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://localhost:8080")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS").allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

}