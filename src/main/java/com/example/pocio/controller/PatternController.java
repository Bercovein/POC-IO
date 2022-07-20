package com.example.pocio.controller;

import com.example.pocio.patterns.adapter.RoundHole;
import com.example.pocio.patterns.adapter.RoundPiece;
import com.example.pocio.patterns.adapter.SquarePiece;
import com.example.pocio.patterns.adapter.SquarePieceAdapter;
import com.example.pocio.patterns.factory.Circle;
import com.example.pocio.patterns.factory.Figure;
import com.example.pocio.patterns.factory.FigureFactory;
import com.example.pocio.patterns.factory.FigureType;
import com.example.pocio.patterns.factory.Rectangle;
import com.example.pocio.patterns.factory.Triangle;
import com.example.pocio.patterns.observer.Editor;
import com.example.pocio.patterns.observer.EmailNotificationListener;
import com.example.pocio.patterns.observer.LogOpenListener;
import com.example.pocio.patterns.singleton.Singleton;
import com.example.pocio.patterns.strategy.PayByCreditCard;
import com.example.pocio.patterns.strategy.PayByPayPal;
import com.example.pocio.patterns.strategy.PayStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.css.Rect;

@RestController
@RequestMapping("/pattern")
public class PatternController {

    @GetMapping("/singleton")
    public void singleton() {
        System.out.println("---SINGLETON---");
        System.out.println("Si vemos dos valores iguales entonces el singleton funciona:");
        Singleton singleton = Singleton.getInstance("Valor 1");
        Singleton anotherSingleton = Singleton.getInstance("Valor 2");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

    @GetMapping("/observer")
    public void observer(){
        System.out.println("---OBSERVER---");
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/adapter/{hole}/{piece}")
    public void adapter(@PathVariable("hole") int hole,@PathVariable("piece") int piece){
        System.out.println("---ADAPTER---");

        RoundHole roundHole = new RoundHole(hole);
        SquarePiece square = new SquarePiece(piece);
        RoundPiece round = new RoundPiece(piece);
        // Aplicamos el adaptador
        SquarePieceAdapter smallSquareAdapter = new SquarePieceAdapter(square);

        if(roundHole.fits(round)){
            System.out.println("La pieza REDONDA de " + round.getRadius() +" cm de radio entra en un agujero redondo de " + roundHole.getRadius() + " cm de radio.");
        }else{
            System.out.println("La pieza REDONDA de " + round.getRadius() +" cm de radio NO entra en un agujero redondo de " + roundHole.getRadius() + " cm de radio.");
        }

        if (roundHole.fits(smallSquareAdapter)) {
            System.out.println("La pieza CUADRADA de " + square.getWidth() +" cm entra en un agujero redondo de " + roundHole.getRadius() + " cm de radio.");
        }else{
            System.out.println("La pieza CUADRADA de " + square.getWidth() +" cm NO entra en un agujero redondo de " + roundHole.getRadius() + " cm de radio.");
        }
    }

    @GetMapping("/strategy/pay/{method}/{amount}")
    public void strategy(@PathVariable("method") String method, @PathVariable("amount") int amount){
        System.out.println("---STRATEGY---");

        PayStrategy strategy = null;

        switch (method){
            case "paypal":
                System.out.println("Creating PayPal payment method");
                strategy = new PayByPayPal();
                break;
            case "card":
                System.out.println("Creating Credit Card payment method");
                strategy = new PayByCreditCard();
                break;
        }
        if(strategy != null)
            strategy.pay(amount);

    }

    @GetMapping("/factory")
    public void factory(){
        System.out.println("---FACTORY---");

        Figure figure = FigureFactory.create(FigureType.TRIANGLE);
        Triangle triangle = (Triangle) figure;
        triangle.setBase(5);
        triangle.setHeight(3);

        System.out.println(triangle);
        System.out.println("Area: " + figure.calculateArea());

        figure = FigureFactory.create(FigureType.RECTANGLE);
        Rectangle rectangle = (Rectangle) figure;
        rectangle.setWidth(5);
        rectangle.setHeight(3);

        System.out.println(rectangle);
        System.out.println("Area: " + figure.calculateArea());

        figure = FigureFactory.create(FigureType.CIRCLE);
        Circle circle = (Circle) figure;
        circle.setRadius(5);

        System.out.println(circle);
        System.out.println("Area: " + figure.calculateArea());
    }
}
