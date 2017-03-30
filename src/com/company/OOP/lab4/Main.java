package com.company.OOP.lab4;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: vadym_polyanski
 * Date: 30.03.17
 * Time: 23:00
 */
public class Main {
    private static VectorList vectorList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Create the first vector:");
        int firstA = scanner.nextInt();
        int firstB = scanner.nextInt();
        Vector first = new Vector("first", firstA, firstB);
        System.out.println("Create the second vector:");
        int secondA = scanner.nextInt();
        int secondB = scanner.nextInt();
        Vector second = new Vector("second", secondA, secondB);

        System.out.println("Creation of vector array..");
        vectorList = new VectorList(Arrays.asList(first, second));
        System.out.println("Capacity: " + vectorList.capacity());
        System.out.println("All elements: ");
        vectorList.print();

        System.out.println("Multiplication..");
        Vector product = vectorList.product(first, second);
        System.out.println("Result: ");
        product.print();
        if (product != null) {
            System.out.println("Adding to array: ");
            vectorList.addToEnd(product);
            System.out.println("Capacity: " + vectorList.capacity());
            System.out.println("All elements: ");
            vectorList.print();
        } else {
            System.out.println("Fail with your vectors, sorry..");
        }
    }
}
