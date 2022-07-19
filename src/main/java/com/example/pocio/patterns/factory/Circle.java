package com.example.pocio.patterns.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Circle extends Figure{

    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius,2);
    }
}
