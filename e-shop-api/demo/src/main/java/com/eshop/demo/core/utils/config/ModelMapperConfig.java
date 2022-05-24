package com.eshop.demo.core.utils.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public static final ModelMapper modelMapper(){
        return new ModelMapper();
    }

}