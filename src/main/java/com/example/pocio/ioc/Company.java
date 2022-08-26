package com.example.pocio.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Company {
    private Address address;

    @PostConstruct
    private void preConstruct(){
        System.out.println("Por construir el bean");
    }

    private void init(){
        System.out.println("Iniciando bean");
    }

    @PreDestroy
    private void preDestroy(){
        System.out.println("Por destruir el bean");
    }

    private void destroy(){
        System.out.println("Destruyendo bean");
    }
}