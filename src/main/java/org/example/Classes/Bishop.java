package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Bishop extends ChessPiece {


    public Bishop(String symbol, String color, Location l) {
        super(symbol, color, l);
    }

    @Override
    public boolean checkMove(Location var1, Board var2) {
        return false;
    }
}
