package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Knight extends ChessPiece {


    public Knight(String symbol, String color, Location l) {
        super(symbol, color, l);
    }
    @Override
    public String getType() {
        return "Knight";
    }
    @Override
    public boolean checkMove(Location targetLocation, Board board) {
        int deltaX = Math.abs(targetLocation.x - this.location.x);
        int deltaY = Math.abs(targetLocation.y - this.location.y);

        // Knights move in an L-shape: 2 squares in one direction and 1 square in a perpendicular direction
        if ((deltaX == 2 && deltaY == 1) || (deltaX == 1 && deltaY == 2)) {
            // Check for capturing
            ChessPiece targetPiece = board.getPieceAt(targetLocation);
            if (targetPiece == null || !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false; // Invalid move
    }

}
