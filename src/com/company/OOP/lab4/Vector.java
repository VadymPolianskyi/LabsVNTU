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

    public Vector product(Vector vector) {

        int a = vector.getA();
        int b = vector.getB();
        if (this.a %2 != 0 && this.b %2 !=0
                && a %2 != 0 && b %2 != 0) {
            System.out.println("Elements of these vectors are not paired");
            return null;
        }
        String name = "product of " + getName() + "and" + vector.getName();
        return new Vector(name, this.a*a, this.b*b);
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
