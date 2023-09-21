package org.example;

import java.util.Scanner;

public class Menu {

    private Scanner scan;

    public Menu() {
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

                break;
            case 2:

                break;
            case 3:

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

}
