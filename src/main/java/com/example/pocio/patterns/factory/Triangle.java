package com.example.pocio.patterns.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle extends Figure {

    private double height;
    private double base;

    @Override
    public double calculateArea() {
        return base * height / 2;
    }
}
