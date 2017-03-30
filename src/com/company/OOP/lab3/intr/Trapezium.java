package com.company.OOP.lab3.intr;

/**
 * Author: vadym
 * Date: 16.02.17
 * Time: 22:13
 */
public class Trapezium implements Shape {
    double c;
    double d;
    double h;

    public Trapezium(double c, double d, double h) {
        this.c = c;
        this.d = d;
        this.h = h;
    }

    @Override
    public Double GetArea() {
        return 0.5 * h *(c + d);
    }
}
