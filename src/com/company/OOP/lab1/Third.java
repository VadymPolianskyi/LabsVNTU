package com.company.OOP.lab1;

public class Third {

    public static void convert(int lowerLimit, int upperLimit) {
        if (lowerLimit < -459) {
            System.out.println("You can't enter value of Fahrenheit temperature less than -459! ");
        }
        if (upperLimit < lowerLimit) {
            System.out.println("Enter correct limits..");
        }

        float fahrenheitTemperature;
        int counter = 1;

        System.out.println("Fahrenheit temperature" + "   -   " + "Celsius temperature");

        while (lowerLimit <= upperLimit) {
            fahrenheitTemperature = lowerLimit;
            convertToCels(fahrenheitTemperature, counter);
            lowerLimit++;
            counter++;
        }
    }

    private static void convertToCels(float fahrenheitTemperature, int counter) {
        float celsiusTemperature;
        celsiusTemperature = (((fahrenheitTemperature - 32)*5)/9);

        System.out.println(counter + ") " + fahrenheitTemperature + "   -   " + celsiusTemperature);

    }
}
