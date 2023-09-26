package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Bishop extends ChessPiece {


    public Bishop(String symbol, String color, Location l) {
        super(symbol, color, l);
    }
    @Override
    public String getType() {
        return "Bishop";
    }

    @Override
    public boolean checkMove(Location destination, Board board) {
        // Check if the destination is the same as the current location
        if (location.equals(destination)) {
            return false;
        }

        int deltaX = Math.abs(destination.x - location.x);
        int deltaY = Math.abs(destination.y - location.y);

        // A bishop can only move diagonally, so deltaX and deltaY should be equal
        if (deltaX != deltaY) {
            return false;
        }

        // Check if there are any pieces in the diagonal path
        int xDirection = (destination.x > location.x) ? 1 : -1;
        int yDirection = (destination.y > location.y) ? 1 : -1;

        int currentX = location.x + xDirection;
        int currentY = location.y + yDirection;

        while (currentX != destination.x && currentY != destination.y) {
            if (board.getPieceAt(new Location(currentX, currentY)) != null) {
                // There is a piece in the diagonal path
                return false;
            }
            currentX += xDirection;
            currentY += yDirection;
        }

        // Destination is a valid diagonal move
        return true;
    }
}

