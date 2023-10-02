package org.example;

import org.example.Classes.*;

public class Board {
     private ChessPiece[][] board;



     public Board() {

          this.board = new ChessPiece[8][8];
          this.setup();
     }

     void setup() {
          for(int i = 0; i < 8; ++i) {
               this.board[i][1] = new Pawn("♙", "WHITE", new Location(i, 1));
               this.board[i][6] = new Pawn("♟", "BLACK", new Location(i, 6));
          }

          this.board[0][0] = new Rook("♜", "WHITE", new Location(0, 0));
          this.board[7][0] = new Rook("♜", "WHITE", new Location(7, 0));
          this.board[0][7] = new Rook("♖", "BLACK", new Location(0, 7));
          this.board[7][7] = new Rook("♖", "BLACK", new Location(7, 7));
          this.board[1][0] = new Knight("♞", "WHITE", new Location(1, 0));
          this.board[6][0] = new Knight("♞", "WHITE", new Location(6, 0));
          this.board[1][7] = new Knight("♘", "BLACK", new Location(1, 7));
          this.board[6][7] = new Knight("♘", "BLACK", new Location(6, 7));
          this.board[2][0] = new Bishop("♝", "WHITE", new Location(2, 0));
          this.board[5][0] = new Bishop("♝", "WHITE", new Location(5, 0));
          this.board[2][7] = new Bishop("♗", "BLACK", new Location(2, 7));
          this.board[5][7] = new Bishop("♗", "BLACK", new Location(5, 7));
          this.board[3][0] = new Queen("♛", "WHITE", new Location(3, 0));
          this.board[3][7] = new Queen("♕", "BLACK", new Location(3, 7));
          this.board[4][0] = new King("♚", "WHITE", new Location(4, 0));
          this.board[4][7] = new King("♔", "BLACK", new Location(4, 7));
     }

     public ChessPiece[][] getBoard() {
          return this.board;
     }

     public ChessPiece getPieceAt(Location location) {
          if (isValidLocation(location)) {
               return board[location.x][location.y];
          } else {
               // Handle invalid location (e.g., out of bounds)
               return null;
          }
     }

     private boolean isValidLocation(Location location) {
          return location.x >= 0 && location.x < 8 && location.y >= 0 && location.y < 8;
     }

     public boolean movePiece(Location from, Location to, String currentPlayerColor) {
          ChessPiece pieceToMove = getPieceAt(from);
          ChessPiece targetPiece = getPieceAt(to);

          if (pieceToMove == null || !pieceToMove.getColor().equals(currentPlayerColor)) {
               // The piece to move is either null or doesn't belong to the current player
               return false;
          }

          if (pieceToMove.checkMove(to, this)) {
               // The move is valid according to the specific chess piece's rules
               // Check if the target square is empty or contains an opponent's piece
               if (targetPiece == null || !targetPiece.getColor().equals(currentPlayerColor)) {
                    // Move the piece to the target location
                    board[to.getX()][to.getY()] = pieceToMove;
                    board[from.getX()][from.getY()] = null;
                    // Update the piece's location
                    pieceToMove.setLocation(to);
                    // Mark the piece as moved
                    pieceToMove.setMoved(true);
                    return true;
               }
          }
          return false;
     }


}
