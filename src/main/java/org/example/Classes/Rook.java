package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Rook extends ChessPiece {

    public Rook(String symbol, String color, Location l) {
        super(symbol, color, l);
    }

    @Override
    public boolean checkMove(Location var1, Board var2) {
        return false;
    }
}
