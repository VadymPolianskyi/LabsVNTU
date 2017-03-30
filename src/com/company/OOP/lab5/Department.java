package com.company.OOP.lab5;

import java.io.Serializable;

public class Department implements Serializable {

    private static final long serialVersionUID = 5681806210772351755L;

    private int planHours;
    private int factHours;
    private String name;

    public Department(int planHours, int factHours, String name) {
        this.planHours = planHours;
        this.factHours = factHours;
        this.name = name;
    }

    public void setPlanHours(int planHours) {
        this.planHours = planHours;
    }

    public void setFactHours(int factHours) {
        this.factHours = factHours;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlanHours() {
        return planHours;
    }

    public int getFactHours() {
        return factHours;
    }

    public String getName() {
        return name;
    }

    public Integer hourDeviationsFromPlan() {
        return planHours - factHours;
    }

    public Float persentDeviationsFromPlan() {
        return Float.valueOf(hourDeviationsFromPlan() * 100/planHours);
    }

    @Override
    public String toString() {
        return "Departmen '" + name + "': Fact hours - " + factHours + " and Plan hours - " + planHours;
    }
}
