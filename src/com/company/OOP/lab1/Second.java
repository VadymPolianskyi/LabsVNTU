package com.company.OOP.lab1;

public class Second {
    public static void calculate(int argument) {
        if (argument < 0) {
            System.out.println("Write only positive numbers!");
        }
        double result;
        result = Math.log(argument);
        System.out.println("ln(" + argument + ") = " + result);
    }
}
