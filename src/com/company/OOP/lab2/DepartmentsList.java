package com.company.OOP.lab2;

import java.util.ArrayList;
import java.util.List;

public class DepartmentsList {
    List<Department> departments;


    public DepartmentsList() {
        this.departments = new ArrayList<Department>();
    }


    public void add(Department element) {
        departments.add(element);
    }

    public int size() {
        return departments.size();
    }

    public void clear() {
        departments.clear();
    }

    public boolean isEmpty() {
        return departments.isEmpty();
    }

    public Department get(int index) {
        return departments.get(index);
    }

    public Department get(String name) {
        for (Department department: departments) {
            if(name.equals(department.getName())) {
                return department;
            }
        }
        return null;
    }

    public Department remove(int index) {
       return departments.remove(index);
    }

    public void remove(Department element) {
        departments.remove(element);
    }

    public Integer getAllPlanHours() {
        int sum = 0;

        for (Department department: departments) {
            sum += department.getPlanHours();
        }

        return sum;
    }

    public Integer getAllFactHours() {
        int sum = 0;

        for (Department department: departments) {
            sum += department.getFactHours();
        }

        return sum;
    }

    public void displayAll() {
        for (Department department: departments) {
            System.out.println(department);
        }
    }
}
