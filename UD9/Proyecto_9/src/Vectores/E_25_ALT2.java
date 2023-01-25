package Vectores;

import java.util.Scanner;

public class E_25_ALT2 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of workers: ");
        int nWorkers = input.nextInt();

        double[][] workers = new double[nWorkers][2];

        for (int i = 0; i < nWorkers; i++) {
            System.out.println("Enter the worker's gender (0 for male, 1 for female): ");
            workers[i][0] = input.nextInt();
            System.out.println("Enter the worker's salary: ");
            workers[i][1] = input.nextDouble();
        }

        double maleSalarySum = 0;
        double femaleSalarySum = 0;
        int maleWorkers = 0;
        int femaleWorkers = 0;

        for (int i = 0; i < nWorkers; i++) {
            if (workers[i][0] == 0) {
                maleSalarySum += workers[i][1];
                maleWorkers++;
            } else {
                femaleSalarySum += workers[i][1];
                femaleWorkers++;
            }
        }

        double maleAverage = maleSalarySum / maleWorkers;
        double femaleAverage = femaleSalarySum / femaleWorkers;
        System.out.println("Average salary for male workers: " + maleAverage);
        System.out.println("Average salary for female workers: " + femaleAverage);

        if (maleAverage > femaleAverage) {
            System.out.println("There is a wage gap, with male workers earning more on average than female workers.");
        } else if (femaleAverage > maleAverage) {
            System.out.println("There is a wage gap, with female workers earning more on average than male workers.");
        } else {
            System.out.println("There is no wage gap, male and female workers earn the same average salary.");
        }
    }
}
