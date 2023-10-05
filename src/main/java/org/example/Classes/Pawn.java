package org.example.Classes;

import org.example.Board;
import org.example.Location;

public class Pawn extends ChessPiece{


    public Pawn(String symbol, String color, Location l) {
        super(symbol, color, l);
    }

    @Override
    public boolean checkMove(Location targetLocation, Board board) {
        int deltaX = Math.abs(targetLocation.x - this.location.x);
        int deltaY = Math.abs(targetLocation.y - this.location.y);

        if (this.color.equals("WHITE")) {
            // Move forward one square
            if (deltaX == 0 && deltaY == 1 && targetLocation.y > this.location.y) {
                if (board.getPieceAt(targetLocation) == null) {
                    // Regular move
                    return true;
                }
            }

            else if (deltaX == 1 && deltaY == 1 && targetLocation.y > this.location.y) {
                if (board.getPieceAt(targetLocation) != null) {
                    // Capture
                    return true;
                }
            }
            // Move forward two squares on the first move
            else if (deltaX == 0 && deltaY == 2 && targetLocation.y == this.location.y + 2) {
                if (this.location.y == 1 && board.getPieceAt(targetLocation) == null
                        && board.getPieceAt(new Location(this.location.x, this.location.y + 1)) == null) {
                    return true;
                }
            }
        } else if (this.color.equals("BLACK")) {
            // Move forward one square
            if (deltaX == 0 && deltaY == 1 && targetLocation.y < this.location.y) {
                if (board.getPieceAt(targetLocation) == null) {
                    // Regular move
                    return true;
                }
            }
            // Capture diagonally
            else if (deltaX == 1 && deltaY == 1 && targetLocation.y < this.location.y) {
                if (board.getPieceAt(targetLocation) != null) {
                    // Capture
                    return true;
                }
            }
            // Move forward two squares on the first move
            else if (deltaX == 0 && deltaY == 2 && targetLocation.y == this.location.y - 2) {
                if (this.location.y == 6 && board.getPieceAt(targetLocation) == null
                        && board.getPieceAt(new Location(this.location.x, this.location.y - 1)) == null) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String getType() {
        return "Pawn";
    }
}
