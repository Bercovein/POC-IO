package com.example.pocio.model;

import com.example.pocio.model.interfaces.IPerson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Person implements IPerson {

    private int age;
    private String name;
    private String lastName;
    private List<Car> cars;

    @Override
    public String getFullName() {
        return this.name.concat(" ").concat(lastName);
    }

    public abstract String getInitials();

}
