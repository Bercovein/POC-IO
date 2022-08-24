package com.example.pocio.controller;

import com.example.pocio.ioc.Address;
import com.example.pocio.ioc.Company;
import com.example.pocio.ioc.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ioc")
@Slf4j
public class IOCController {

    @GetMapping
    public void inversionOfControl() {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company = context.getBean("company", Company.class);

        Company company1 = new Company(new Address("Calle falsa", 123));

        System.out.println("With Context ".concat(company.toString()));
        System.out.println("Without Context ".concat(company1.toString()));
    }

}
