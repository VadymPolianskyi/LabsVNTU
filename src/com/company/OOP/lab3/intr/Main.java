package com.company.OOP.lab3.intr;

import java.util.Scanner;

/**
 * Author: vadym
 * Date: 16.02.17
 * Time: 22:16
 */
public class Main {
    private static boolean workOfProgram = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape interfShape;

        System.out.println("Enter to run:\n" +
                "'t' - trapezium\n" +
                "'p' - parallelogram\n" +
                "'e' - exit\n");

        while (workOfProgram) {

            String comandShape = scanner.nextLine();

            if (checkComand(comandShape)) {
                switch (comandShape) {
                    case "p":
                        System.out.print("Enter a: ");
                        double a = scanner.nextDouble();
                        System.out.print("Enter h: ");
                        double h = scanner.nextDouble();
                        interfShape = new Parallelogram(a, h);
                        System.out.println("Area of parallelogram: " + interfShape.GetArea() + "\n");
                        System.out.println("Enter comand again: ");
                        break;
                    case "t":
                        System.out.print("Enter c: ");
                        double c = scanner.nextDouble();
                        System.out.print("Enter d: ");
                        double d = scanner.nextDouble();
                        System.out.print("Enter h: ");
                        double h1 = scanner.nextDouble();
                        interfShape = new Trapezium(c, d, h1);
                        System.out.println("Area of trapezium: " + interfShape.GetArea() + "\n");
                        System.out.println("Enter comand again: ");
                        break;
                    case "e":
                        finishOfProgram();
                        break;
                    default:
                        System.out.println("Enter  correct comand: \n");
                        break;
                }
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
