package com.utsem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TiendaSeguraApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiendaSeguraApplication.class, args);
	}

	@Bean
	WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://127.0.0.1:8080", "https//localhost:8080")
						.allowedMethods("*")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};

}
}
