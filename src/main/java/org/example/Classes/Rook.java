package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Rook extends ChessPiece {

    public Rook(String symbol, String color, Location l) {
        super(symbol, color, l);
    }

    @Override
    public boolean checkMove(Location targetLocation, Board board) {
        int deltaX = Math.abs(targetLocation.x - this.location.x);
        int deltaY = Math.abs(targetLocation.y - this.location.y);

        // Rooks can move vertically or horizontally
        if (deltaX == 0 && deltaY > 0 || deltaX > 0 && deltaY == 0) {
            // Check for pieces in the path (excluding the target square)
            if (targetLocation.x == this.location.x) {
                int step = (targetLocation.y > this.location.y) ? 1 : -1;
                for (int y = this.location.y + step; y != targetLocation.y; y += step) {
                    if (board.getPieceAt(new Location(this.location.x, y)) != null) {
                        return false; // Piece in the path
                    }
                }
            } else {
                int step = (targetLocation.x > this.location.x) ? 1 : -1;
                for (int x = this.location.x + step; x != targetLocation.x; x += step) {
                    if (board.getPieceAt(new Location(x, this.location.y)) != null) {
                        return false; // Piece in the path
                    }
                }
            }

            // Check for capturing
            if (board.getPieceAt(targetLocation) == null || !board.getPieceAt(targetLocation).getColor().equals(this.color)) {
                return true;
            }
        }

        return false; // Invalid move
    }

}
