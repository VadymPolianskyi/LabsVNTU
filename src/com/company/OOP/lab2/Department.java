package com.company.OOP.lab2;

/**
 * Created by vadym on 31.01.17.
 */
public class Department {
    private int planHours;
    private int factHours;

    public Department(int planHours, int factHours) {
        this.planHours = planHours;
        this.factHours = factHours;
    }

    public void setPlanHours(int planHours) {
        this.planHours = planHours;
    }

    public void setFactHours(int factHours) {
        this.factHours = factHours;
    }

    public int getPlanHours() {
        return planHours;
    }

    public int getFactHours() {
        return factHours;
    }

    public Integer hourDeviationsFromPlan() {
        return planHours - factHours;
    }

    public Float persentDeviationsFromPlan() {
        return Float.valueOf(hourDeviationsFromPlan() * 100/planHours);
    }

    @Override
    public String toString() {
        return "Fact hours - " + factHours + " and Plan hours - " + planHours;
    }
}
