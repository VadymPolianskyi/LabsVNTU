package com.company.OOP.lab4;

/**
 * Author: vadym_polyanski
 * Date: 30.03.17
 * Time: 22:35
 */
public class Vector {
    private String name;
    int a;
    int b;

    public Vector(String name, int a, int b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void print() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Vector{" +
                "name='" + name + '\'' +
                ", a=" + a +
                ", b=" + b +
                '}';
    }
}
