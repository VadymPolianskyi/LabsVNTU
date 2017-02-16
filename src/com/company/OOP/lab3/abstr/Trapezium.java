package com.company.OOP.lab3.abstr;

/**
 * Author: vadym
 * Date: 16.02.17
 * Time: 22:13
 */
public class Trapezium extends Shape {
    double c;
    double d;
    double h;

    public Trapezium(double c, double d, double h) {
        this.c = c;
        this.d = d;
        this.h = h;
    }

    @Override
    Double GetArea() {
        return 0.5 * (c + (d*h));
    }
}
