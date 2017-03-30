package com.company.TSI.lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your hex number: ");

        String numberInHex = sc.nextLine();

        BitStuffing.doBitStuffing(numberInHex);
    }
}
