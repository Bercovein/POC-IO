package com.example.pocio.patterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class SquarePieceAdapter extends RoundPiece {

    private SquarePiece piece;

    @Override
    public double getRadius(){ //calcula el radio minimo en el que puede entrar la pieza
        return (Math.sqrt(Math.pow((piece.getWidth() / 2), 2) * 2));
    }
}