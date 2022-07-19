package com.example.pocio.patterns.factory;

public class FigureFactory {

    public static Figure create(FigureType figureType){
       switch (figureType){
            case TRIANGLE:
                return new Triangle();
            case RECTANGLE:
                return new Rectangle();
           default:
                return new Circle();
        }
    }
}
