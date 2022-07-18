package com.example.pocio.patterns.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoundHole {
    private final double radius;

    public boolean fits(RoundPiece piece) {
        return (this.getRadius() >= piece.getRadius());
    }
}
