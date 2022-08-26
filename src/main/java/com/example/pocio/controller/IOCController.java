package com.example.pocio.controller;

import com.example.pocio.ioc.Address;
import com.example.pocio.ioc.Company;
import com.example.pocio.ioc.Config;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ioc")
@Slf4j
public class IOCController {

    @GetMapping
    public void inversionOfControl() {

        Company company1 = new Company(new Address("Calle falsa", 123));
        System.out.println("Without Context ".concat(company1.toString()));

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Company company2 = context.getBean("company", Company.class);
        System.out.println("With Context ".concat(company2.toString()));

        ((ConfigurableApplicationContext)context).close();

        ApplicationContext contextWithXML = new ClassPathXmlApplicationContext("classpath*:context.xml");
        Company company3 = contextWithXML.getBean(Company.class);
        System.out.println("With Container Context ".concat(company3.toString()));

        ((ConfigurableApplicationContext)contextWithXML).close();

    }

}
