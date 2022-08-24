package com.example.pocio.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = Company.class) //indica donde buscar los beans
public class Config {
    @Bean
    public Address getAddress() {
        return new Address("Avenida Siempre Viva", 742);
    }
}