package com.utsem;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration

public class modelMapperConfig {
	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
