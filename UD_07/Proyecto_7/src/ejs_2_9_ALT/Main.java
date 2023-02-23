package ejs_2_9_ALT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean hasWon = false;
        MasterMind game = new MasterMind(4, 10);

        while (game.hasAttemptsLeft()) {
            System.out.println("You have " + game.getAttemptsLeft() + " attempts left.");
            System.out.println("Enter a 4-digit number without repeating digits:");
            String enteredNumber = input.nextLine();

            if (!game.isValidInput(enteredNumber)) {
                System.out.println("Invalid input, please enter a 4-digit number without repeating digits.");
                continue;
            }
            game.setEnteredNumber(enteredNumber);

            if (game.checkAnswer()) {
                hasWon = true;
                break;
            }
            System.out.println(game.getCorrectlyPlacedDigits() + " digit(s) are correctly placed, " + game.getIncorrectlyPlacedDigits() + " digit(s) are in the correct number but in the wrong position.");
        }

        if (hasWon) {
            System.out.println("Congratulations! You have won the game. The correct number was " + game.getCorrectNumber() + ".");
        } else {
            System.out.println("Sorry, you have run out of attempts. The correct number was " + game.getCorrectNumber() + ".");
        }
    }
}





