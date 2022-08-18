package com.example.pocio.controller;

import com.example.pocio.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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

        hashSet.remove("Collection");

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
        for (Car car : hashSetCars) { // <- Se repiten porque utilizan distinta dirección de memoria. (descomentar eq y hc)
            System.out.println(car);
        }

        //TreeMap
        Map<String,String> map = new TreeMap<>();
//        Map<String,String> map = new LinkedHashMap<>(); //<- Persiste el orden de inserción
        map.put("3","Toyota");
        map.put("4","Ford");
        map.put("1","Chevrolet");
        map.put("2","Fiat");
        map.put("5",null);
        map.put("5","Subaru"); //<- pisa el valor seteado anteriormente

        Iterator it=map.keySet().iterator();

        System.out.println("-------TREEMAP-------");
        while(it.hasNext()) { // <- Lo muestra ordenado
            String key = (String) it.next();
            System.out.println("Clave:" + key + "->Valor:" + map.get(key));
        }

        //LinkedHashMap
        Map<Car,String> lhmap = new LinkedHashMap<>(); //<- Persiste el orden de inserción
        lhmap.put(new Car("Corolla","Toyota",10000),"Toyota");
        lhmap.put(new Car("Mustang","Ford",1000),"Ford");
        lhmap.put(new Car("Camaro","Chevrolet",100),"Chevrolet");
        lhmap.put(new Car("Corolla","Toyota",10),"Fiat");
        lhmap.put(new Car("Corolla","Toyota",10),null);
        lhmap.put(new Car("Impresa","Subaru",9000),"Subaru"); //<- pisa el valor seteado anteriormente

        Iterator lhit=lhmap.keySet().iterator();

        System.out.println("-------LINKEDHASHMAP-------");
        while(lhit.hasNext()) { // <- Lo muestra ordenado
            Car key = (Car) lhit.next();
            System.out.println("Clave:" + key + "->Valor:" + lhmap.get(key));
        }

    }

}
