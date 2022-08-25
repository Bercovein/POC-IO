package com.example.pocio.ioc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Company {
    private Address address;

    private void init(){
        System.out.println("Iniciando bean");
    }

    private void destroy(){
        System.out.println("Destruyendo bean");
    }
}