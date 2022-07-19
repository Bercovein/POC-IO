package com.example.pocio.patterns.factory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Rectangle extends Figure{

    public double height;
    public double width;


    @Override
    public double calculateArea() {
        return height * width;
    }
}
