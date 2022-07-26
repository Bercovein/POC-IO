package com.example.pocio.controller;

import com.example.pocio.model.Car;
import com.example.pocio.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/capabilities")
public class CapabilitiesController {

    @GetMapping
    public void capability() throws CloneNotSupportedException {

        //casting
        double myDouble = 2.55d;
        int myInt = (int) myDouble;
        System.out.println(myInt);

        Client client = new Client(30,"Jorge", "Garcia", new ArrayList<>(), "123456789");

        System.out.println(client.getFullName());
        System.out.println(client.getFullName2());

        Car car = new Car("","",100);

//        car.setPrice(1);
//        car.setPrice(1.7f);
//        car.setPrice(1.7f,0.5f);

        car.gerProperties();

        IGreeting greeting = new Greeting() {
            @Override
            public void sayHi() {
                System.out.println("Implementación anónima");
            }
        };

        greeting.sayHi();

        greeting = () -> System.out.println("Implementación anónima con lambda");

        greeting.sayHi();

        //MUTABLES
        String chain = "Hello";
        chain = chain + " world";

        StringBuilder chainBuilder = new StringBuilder("Hello");
        chainBuilder.append(" to all");

        //Cloning
        Car car2 = (Car) car.clone();

        System.out.println(car2);

    }

    private interface IGreeting{
        void sayHi();
    }

    private class Greeting implements IGreeting{

        String salute;

        @Override
        public void sayHi() {
            System.out.println(salute);
        }
    }
}
