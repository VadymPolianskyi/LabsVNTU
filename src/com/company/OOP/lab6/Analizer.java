package com.company.OOP.lab6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by vadym on 21.04.2017.
 */
public class Analizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, write the string 'word word': ");

        while (true) {
            String string = scanner.nextLine();
            if (check(string)) {
                System.out.println("Good result!");
            } else {
                System.out.println("Bad result..");
            }
        }
    }

    public static boolean check(String str){
        Pattern p = Pattern.compile("\\b[a-z]+\\b(\\s)+\\b[a-z]+");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
