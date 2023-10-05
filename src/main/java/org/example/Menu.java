package org.example;

import org.example.Classes.ChessPiece;

import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class Menu {

    private  boolean whiteTurn;
    private Scanner scan;
    private Board b = new Board() ;

    public Menu() {
        this.whiteTurn = true; // White starts first
        this.scan = new Scanner(System.in);
        this.start();
    }

    private void start() {
        System.out.print("\u001b[1;37m\u001b[H\u001b[2J\tWelcome to console chess!\n\u001b[0;32m\n1. Play the game\u001b[0;36m\n2. Help\u001b[0;31m\n3. Exit\n\u001b[0m\nEnter input: ");
        int Entering = -1;
        String input = this.scan.nextLine();

        try {
            Entering = Integer.parseInt(input);
        } catch (Exception e) {
            if (!input.equals("")) {
                this.wait("You have entered incorrect input. Please enter an integer");
                this.start();
            } else {

            }
        }

        switch (Entering) {
            case 1:
                System.out.print("Player 1, choose your color (WHITE/BLACK): ");
                String player1Color = this.scan.nextLine().toUpperCase();
                String player2Color = (player1Color.equals("WHITE")) ? "BLACK" : "WHITE";
                playGame(player1Color,player2Color);
                break;
            case 2:
                this.giveHelp();
                this.start();
                break;
            case 3:
                System.out.print("Bye!\n");
                System.exit(0);
            default:
                System.out.print("\u001b[0;31m");
                this.wait("You have entered incorrect input");
                System.out.print("\u001b[0m");
                this.start();
        }

    }

    private void wait(String message) {
        try {
            System.out.println(message + "\nPress enter or return to continue");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }
    private void slowPrint(String str) {
        try {
            char[] var5;
            int var4 = (var5 = str.toCharArray()).length;

            for(int i = 0; i < var4; ++i) {
                char c = var5[i];
                System.out.print(c);
                Thread.sleep(25L);
            }
        } catch (Exception var6) {
            var6.printStackTrace();
            System.out.println("Error printing");
        }

    }
    private void giveHelp() {
        this.slowPrint("\tHow to play the game\nHow to play chess: https://www.chess.com/learn-how-to-play-chess\n\tHow to use this console chess game\nUse [Position of piece you want to move] [Position you want piece to move to]\nExample - \"e2 e4\"\n\n");
        this.wait("");
    }


    private void displayChessboard() {
        ChessPiece[][] board = b.getBoard();

        // Display column labels (alphabets)
        System.out.print("  ");
        for (char colLabel = 'a'; colLabel <= 'h'; colLabel++) {
            System.out.print("  " + colLabel);
        }
        System.out.println();

        // Display the chessboard
        for (int row = 7; row >= 0; row--) {
            // Display row label (numbers)
            System.out.print((row + 1) + " ");

            for (int col = 0; col < 8; col++) {
                if (board[col][row] != null) {
                    System.out.print(" " + board[col][row].getSymbol() + " ");
                } else {
                    System.out.print(" .  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public void playGame(String player1Color, String player2Color) {
        // Initialize the game state
        boolean gameOver = false;
        String currentPlayerColor = player1Color; // White starts first

        while (!gameOver) {
            // Display the chessboard
            displayChessboard();

            // Prompt the current player for a move
            System.out.println("Player " + (currentPlayerColor.equals("WHITE") ? "1" : "2") + "'s turn ("
                    + currentPlayerColor + "): Enter your move (e.g., 'e2 e4'): ");
            String move = scan.nextLine();

            // Parse the move and validate it
            if (!isValidMove(move, currentPlayerColor)) {
                System.out.println("Invalid move. Try again.");
                continue; // Ask the player for input again
            }

            // Apply the move to the board
            String[] moveParts = move.split(" ");
            Location from = new Location(moveParts[0]);
            Location to = new Location(moveParts[1]);

            // Check if the move is valid for the current player
            if (!b.movePiece(from, to, currentPlayerColor)) {
                System.out.println("Invalid move. Try again.");
                continue; // Ask the player for input again
            }

            // Check for checkmate, stalemate, or other game-ending conditions
            if (isCheckmate(currentPlayerColor)) {
                System.out.println("Checkmate! Player " + (currentPlayerColor.equals("WHITE") ? "1" : "2") + " wins!");
                gameOver = true;
            } else if (isStalemate(currentPlayerColor)) {
                System.out.println("Stalemate! The game is a draw.");
                gameOver = true;
            } else {
                // Switch to the other player's turn
                currentPlayerColor = (currentPlayerColor.equals("WHITE")) ? "BLACK" : "WHITE";
            }
        }
    }



    private boolean isValidMove(String move, String currentPlayerColor) {
        // Parse the move and validate it
        String[] moveParts = move.split(" ");
        if (moveParts.length != 2) {
            return false; // Invalid format
        }

        Location from = new Location(moveParts[0]);
        Location to = new Location(moveParts[1]);

        ChessPiece pieceToMove = b.getPieceAt(from);
        if (pieceToMove == null || !pieceToMove.getColor().equals(currentPlayerColor)) {
            return false; // The piece to move is either null or doesn't belong to the current player
        }

        return pieceToMove.checkMove(to, b);
    }

    private boolean isCheckmate(String currentPlayerColor) {

        return false;
    }

    private boolean isStalemate(String currentPlayerColor) {

        return false;
    }

    private boolean IsInCheck(String currentPlayerColor){


        return false;

    }

    private List<ChessPiece> GetPlayerPieces(String currentPlayerColor){


        return null;
    }

}
