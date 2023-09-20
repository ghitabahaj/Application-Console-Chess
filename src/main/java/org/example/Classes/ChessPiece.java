package org.example.Classes;

public abstract class ChessPiece {

    private boolean isWhite;

    public ChessPiece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public abstract boolean validateMove(int sourceX, int sourceY, int destX, int destY, ChessPiece[][] board);

}
