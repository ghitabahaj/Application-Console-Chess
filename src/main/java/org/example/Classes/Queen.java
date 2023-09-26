package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Queen extends ChessPiece{

    public Queen(String symbol, String color, Location l) {
        super(symbol, color, l);
    }
    @Override
    public String getType() {
        return "Queen";
    }
    @Override
    public boolean checkMove(Location targetLocation, Board board) {
        int deltaX = Math.abs(targetLocation.x - this.location.x);
        int deltaY = Math.abs(targetLocation.y - this.location.y);

        // Queens can move vertically, horizontally, or diagonally
        if ((deltaX == 0 && deltaY > 0) || (deltaX > 0 && deltaY == 0) || (deltaX == deltaY && deltaX > 0)) {
            // Check for pieces in the path (excluding the target square)
            if (targetLocation.x == this.location.x) {
                int step = (targetLocation.y > this.location.y) ? 1 : -1;
                for (int y = this.location.y + step; y != targetLocation.y; y += step) {
                    if (board.getPieceAt(new Location(this.location.x, y)) != null) {
                        return false; // Piece in the path
                    }
                }
            } else if (targetLocation.y == this.location.y) {
                int step = (targetLocation.x > this.location.x) ? 1 : -1;
                for (int x = this.location.x + step; x != targetLocation.x; x += step) {
                    if (board.getPieceAt(new Location(x, this.location.y)) != null) {
                        return false; // Piece in the path
                    }
                }
            } else {
                int xStep = (targetLocation.x > this.location.x) ? 1 : -1;
                int yStep = (targetLocation.y > this.location.y) ? 1 : -1;
                int x = this.location.x + xStep;
                int y = this.location.y + yStep;
                while (x != targetLocation.x && y != targetLocation.y) {
                    if (board.getPieceAt(new Location(x, y)) != null) {
                        return false; // Piece in the path
                    }
                    x += xStep;
                    y += yStep;
                }
            }

            // Check for capturing
            ChessPiece targetPiece = board.getPieceAt(targetLocation);
            if (targetPiece == null || !targetPiece.getColor().equals(this.color)) {
                return true;
            }
        }

        return false; // Invalid move
    }


}
