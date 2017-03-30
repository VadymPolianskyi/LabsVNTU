package com.company.OOP.lab1;

import java.util.Scanner;

public class Main {
    private static boolean workOfProgram = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comand;

        System.out.println("Enter to run:\n" +
                "'f' - first program\n" +
                "'s' - second program\n" +
                "'t' - third program\n" +
                "'e' - exit");

        while (workOfProgram) {
            comand = scanner.nextLine();
            if (checkComand(comand)) {

                switch (comand) {
                    case "f":
                        First.printDate();
                        break;
                    case "s":
                        System.out.print("Enter argument: ");
                        int argument = scanner.nextInt();
                        Second.calculate(argument);
                        break;
                    case "t":
                        int upperLimit, lowerLimit;
                        System.out.print("Enter lower limit: ");
                        lowerLimit = scanner.nextInt();
                        System.out.print("Enter upper limit: ");
                        upperLimit = scanner.nextInt();
                        Third.convert(lowerLimit, upperLimit);
                        break;
                    case "e":
                        finishOfProgram();
                        break;
                    default:
                        System.out.println("Enter correct comand: \n");
                }
                System.out.println("Enter comand again: ");
            }
        }
    }

    public static boolean checkComand(String comand) {
        if (comand.length() > 1 || comand.length() == 0) {
            return false;
        }
        return true;
    }

    private static void finishOfProgram() {
        workOfProgram = false;
    }
}
