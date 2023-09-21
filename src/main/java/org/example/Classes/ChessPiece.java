package org.example.Classes;

import org.example.Board;
import org.example.Location;

import java.util.ArrayList;

public abstract class ChessPiece {

    protected String symbol;
    protected String color;
    protected boolean moved;
    protected Location location;

    public abstract boolean checkMove(Location var1, Board var2);

    public ChessPiece(String symbol, String color, Location l) {
        this.symbol = symbol;
        this.color = color;
        this.location = l;
        this.moved = false;
    }



}
