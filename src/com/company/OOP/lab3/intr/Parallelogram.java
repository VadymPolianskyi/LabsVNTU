package com.company.OOP.lab3.intr;

/**
 * Author: vadym
 * Date: 16.02.17
 * Time: 22:12
 */
public class Parallelogram implements Shape {
    double a;
    double h;

    public Parallelogram(double a, double h) {
        this.a = a;
        this.h = h;
    }

    @Override
    public Double GetArea() {
        return a * h;
    }
}
