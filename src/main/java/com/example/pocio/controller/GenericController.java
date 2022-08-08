package com.example.pocio.controller;

import com.example.pocio.model.Potion;
import com.example.pocio.model.Scroll;
import com.example.pocio.model.WizardBag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic")
public class GenericController {

    @GetMapping
    public void generics() {

        WizardBag bag = new WizardBag();

        bag.add(new Scroll("Fly","Permite levitar durante 10 min a quien lo lea."));
        bag.add(new Potion("Heal Potion","Cura heridas leves."));

        bag.showItems();
    }

}
