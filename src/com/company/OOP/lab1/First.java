package com.company.OOP.lab1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class First {
    private static String studentSurname = "Polyanski";

    public static void printDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(studentSurname + " | Date: " +dateFormat.format(date));
    }

    public static void setDefaultStudentSurame() {
        studentSurname = "Polyanski";
    }

    public static void setStudentSurname(String newStudentSurname) {
        if (newStudentSurname == "" ) {
            setDefaultStudentSurame();
        }
        studentSurname = newStudentSurname;
    }
}
