package com.company.OOP.lab3.abstr;

/**
 * Author: vadym
 * Date: 16.02.17
 * Time: 22:12
 */
public class Parallelogram extends Shape{
    double a;
    double h;

    public Parallelogram(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    Double GetArea() {
        return a * h;
    }
}
