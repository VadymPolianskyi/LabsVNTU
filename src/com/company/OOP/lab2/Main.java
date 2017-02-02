package com.company.OOP.lab2;

import java.util.Scanner;

public class Main {

    private static boolean workOfProgram = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comand;
        DepartmentsList departmentsList = new DepartmentsList();

        System.out.println("Enter to run:\n" +
                "'a' - add car time\n" +
                "'d' - display all elements from list\n" +
                "'c' - clear list\n" +
                "'r' - remove element\n" +
                "'g' - get element to index\n" +
                "'p' - display all plan hours from list\n" +
                "'f' - display all fact hours from list\n" +
                "'s' - display size of list\n" +
                "'e' - exit");

        while (workOfProgram) {
            comand = scanner.nextLine();
            if (checkComand(comand)) {
                switch (comand) {
                    case "a":
                        System.out.print("Enter fact hours: ");
                        int factHours = scanner.nextInt();
                        System.out.print("Enter plan hours: ");
                        int planHours = scanner.nextInt();
                        departmentsList.add(new Department(planHours, factHours));
                        break;
                    case "d":
                        departmentsList.displayAll();
                        break;
                    case "c":
                        departmentsList.clear();
                        break;
                    case "r":
                        System.out.print("Enter index of element: ");
                        int indexToRemove = scanner.nextInt();
                        System.out.println("Element " + departmentsList.remove(indexToRemove) + " is removed");
                        break;
                    case "g":
                        System.out.print("Enter index of element: ");
                        int indexToGet = scanner.nextInt();
                        System.out.println(departmentsList.get(indexToGet));
                        break;
                    case "p":
                        System.out.println(departmentsList.getAllPlanHours() + " hours");
                        break;
                    case "f":
                        System.out.println(departmentsList.getAllFactHours() + " hours");
                        break;
                    case "s":
                        if (departmentsList.isEmpty()) {
                            System.out.println("Doesn't have any elements.");
                        } else {
                            System.out.println(departmentsList.size() + " elements.");
                        }
                        break;
                    case "e":
                        finishOfProgram();
                        break;
                    default:
                        System.out.println("Enter correct comand: \n");
                        break;
                }
            }
            System.out.println("Enter comand again: ");
        }
    }

    public static boolean checkComand(String comand) {
        if (comand.length() > 1 || comand.length() == 0) {
            return false;
        }
        return true;
    }

    private static void finishOfProgram() {
        workOfProgram = false;
    }
}
