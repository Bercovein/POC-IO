package com.example.pocio.controller;

import com.example.pocio.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/collections")
public class CollectionsController {

    @GetMapping
    public void collections() {

        //HashSet
        Set<String> hashSet = new HashSet<>();

        hashSet.add("Hola");
        hashSet.add("Mundo");
        hashSet.add("Hola");
        hashSet.add("Lucho");
        hashSet.add("Collection");
//        hashSet.add("Hashing");  // <--Al agregar, no ordena

        System.out.println("-------HASHSET-------");
        for (String elemento : hashSet) {
            System.out.println(elemento);
        }

        //Con objetos
        Set<Car> hashSetCars = new HashSet<>();

        hashSetCars.add(new Car("Corolla","Toyota",10000));
        hashSetCars.add(new Car("Mustang","Ford",10000));
        hashSetCars.add(new Car("Camaro","Chevrolet",10000));
        hashSetCars.add(new Car("Mustang","Ford",10000));
        hashSetCars.add(new Car("Mustang","Ford",10000));

        System.out.println("-------HASHSET-------");
        for (Car car : hashSetCars) { // <- Se repiten porque utilizan distinta dirección de memoria. (descomentar e y h)
            System.out.println(car);
        }


        //TreeMap


        //LinkedHashMap

    }

}
