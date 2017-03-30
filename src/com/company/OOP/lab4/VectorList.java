package com.company.OOP.lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: vadym_polyanski
 * Date: 30.03.17
 * Time: 22:35
 */
public class VectorList {
    private List<Vector> vectors;

//  constructors
    public VectorList() {
        this.vectors = new ArrayList<>();
    }

    public VectorList(List<Vector> vectors) {
        this.vectors = new ArrayList<>();
        this.vectors.addAll(vectors);
    }

    public VectorList(Vector vector) {
        this.vectors = new ArrayList<>();
        vectors.add(vector);
    }

//  mehtods
    public int capacity() {
        return vectors.size();
    }

    public void addToEnd(Vector vector) {
        vectors.add(vector);
    }

    public void print() {
        for (Vector vector : vectors) {
            vector.print();
        }
    }

    public Vector product(Vector first, Vector second) {
        int firstA = first.getA();
        int firstB = first.getB();
        int secondA = second.getA();
        int secondB = second.getB();
        if (firstA %2 != 0 && firstB %2 !=0
                && secondA %2 != 0 && secondB %2 != 0) {
            System.out.println("Elements of these vectors are not paired");
            return null;
        }
        String name = "product of " + first.getName() + "and" + second.getName();
        return new Vector(name, firstA*secondA, firstB*secondB);
    }
}
