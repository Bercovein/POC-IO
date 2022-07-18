package com.example.pocio.controller;

import com.example.pocio.patterns.adapter.RoundHole;
import com.example.pocio.patterns.adapter.SquarePiece;
import com.example.pocio.patterns.adapter.SquarePieceAdapter;
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

@RestController
@RequestMapping("/pattern")
public class PatternController {

    @GetMapping("/singleton")
    public void singleton() {
        System.out.println("Si vemos dos valores iguales entonces el singleton funciona:");
        Singleton singleton = Singleton.getInstance("Valor 1");
        Singleton anotherSingleton = Singleton.getInstance("Valor 2");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

    @GetMapping("/observer")
    public void observer(){
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

    @GetMapping("/adapter")
    public void adapter(){
        RoundHole hole = new RoundHole(5);

        SquarePiece smallSquare = new SquarePiece(2);
        SquarePiece largeSquare = new SquarePiece(20);

        // Aplicamos el adaptador
        SquarePieceAdapter smallSquareAdapter = new SquarePieceAdapter(smallSquare);
        SquarePieceAdapter largeSquareAdapter = new SquarePieceAdapter(largeSquare);
        if (hole.fits(smallSquareAdapter)) {
            System.out.println("La pieza cuadrada de " + smallSquare.getWidth() +" cm entra en un agujero redondo de " + hole.getRadius() + " cm de radio.");
        }
        if (!hole.fits(largeSquareAdapter)) {
            System.out.println("La pieza cuadrada de " + smallSquare.getWidth() +" cm NO entra en un agujero redondo de " + hole.getRadius() + " cm de radio.");

        }
    }

    @GetMapping("/strategy/pay/{method}/{amount}")
    public void strategy(@PathVariable("method") String method, @PathVariable("amount") int amount){

        PayStrategy strategy = null;

        switch (method){
            case "card":
                System.out.println("Creating PayPal payment method");
                strategy = new PayByPayPal();
                break;
            case "paypal":
                System.out.println("Creating Credit Card payment method");
                strategy = new PayByCreditCard();
                break;
        }
        if(strategy != null)
            strategy.pay(amount);

    }
}
