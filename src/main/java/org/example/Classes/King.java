package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class King  extends  ChessPiece{


    public King(String symbol, String color, Location l) {
        super(symbol, color, l);
    }
    @Override
    public String getType() {
        return "King";
    }
    @Override
    public boolean checkMove(Location targetLocation, Board board) {
        int deltaX = Math.abs(targetLocation.x - this.location.x);
        int deltaY = Math.abs(targetLocation.y - this.location.y);

        // Kings can move one square in any direction (horizontally, vertically, or diagonally)
        if ((deltaX == 1 && deltaY == 0) || (deltaX == 0 && deltaY == 1) || (deltaX == 1 && deltaY == 1)) {
            // Check for capturing
            ChessPiece targetPiece = board.getPieceAt(targetLocation);
            if (targetPiece == null || !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false; // Invalid move
    }
}
