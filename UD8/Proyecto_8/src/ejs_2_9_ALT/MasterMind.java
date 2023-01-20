package ejs_2_9_ALT;

import java.util.concurrent.ThreadLocalRandom;

public class MasterMind {

    private final int numberOfDigits;
    private final int totalAttempts;
    private String correctNumber;
    private String enteredNumber;
    private int attemptsLeft;
    private int correctlyPlacedDigits;
    private int incorrectlyPlacedDigits;

    public MasterMind(int numberOfDigits, int totalAttempts) {
        this.numberOfDigits = numberOfDigits;
        this.totalAttempts = totalAttempts;
        String digits = "0123456789";
        correctNumber = "";
        for (int i = 0; i < numberOfDigits; i++) {
            int posRand = ThreadLocalRandom.current().nextInt(0, digits.length());
            correctNumber += digits.charAt(posRand);
            digits = digits.substring(0, posRand) + digits.substring(posRand+1);
        }
        attemptsLeft = totalAttempts;
    }


    public String getCorrectNumber() {
        return correctNumber;
    }
    public void setEnteredNumber(String enteredNumber) {
        this.enteredNumber = enteredNumber;
    }
    public int getAttemptsLeft() {
        return attemptsLeft;
    }
    public int getCorrectlyPlacedDigits() {
        return correctlyPlacedDigits;
    }
    public int getIncorrectlyPlacedDigits() {
        return incorrectlyPlacedDigits;
    }


    public boolean isValidInput(String input) {
        if (input.length() != numberOfDigits) {
            return false;
        }
        for (int i = 0; i < numberOfDigits; i++) {
            for (int j = i+1; j < numberOfDigits; j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkAnswer() {
        attemptsLeft--;
        correctlyPlacedDigits = 0;
        incorrectlyPlacedDigits = 0;
        for (int i = 0; i < numberOfDigits; i++) {
            if (correctNumber.indexOf(enteredNumber.charAt(i)) != -1) {
                if (enteredNumber.charAt(i) == correctNumber.charAt(i)) {
                    correctlyPlacedDigits++;
                } else {
                    incorrectlyPlacedDigits++;
                }
            }
        }
        return correctlyPlacedDigits == numberOfDigits;
    }

    public boolean hasAttemptsLeft() {
        return attemptsLeft > 0;
    }
}





