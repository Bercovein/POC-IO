package com.example.pocio.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class WizardBag<T> {

    private List<T> items;

    public WizardBag() {
        this.items = new ArrayList<>();
    }

    public void add(T item){
        items.add(item);
    }

    public void showItems() {
        for (Object item: items) {
            System.out.println(item.toString());
        }
    }
}
