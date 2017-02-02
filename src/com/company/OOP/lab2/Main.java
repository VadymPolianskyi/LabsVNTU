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
                "'%' - display deviations from plan in %\n" +
                "'k' - display deviations from plan in kW/h\n" +
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
                        System.out.println("Enter comand again: ");
                        break;
                    case "d":
                        departmentsList.displayAll();
                        System.out.println("Enter comand again: ");
                        break;
                    case "c":
                        departmentsList.clear();
                        System.out.println("Enter comand again: ");
                        break;
                    case "r":
                        System.out.print("Enter index of element: ");
                        int indexToRemove = scanner.nextInt();
                        System.out.println("Element " + departmentsList.remove(indexToRemove) + " is removed");
                        System.out.println("Enter comand again: ");
                        break;
                    case "g":
                        System.out.print("Enter index of element: ");
                        int indexToGet = scanner.nextInt();
                        System.out.println(departmentsList.get(indexToGet));
                        System.out.println("Enter comand again: ");
                        break;
                    case "p":
                        System.out.println(departmentsList.getAllPlanHours() + " hours");
                        System.out.println("Enter comand again: ");
                        break;
                    case "f":
                        System.out.println(departmentsList.getAllFactHours() + " hours");
                        System.out.println("Enter comand again: ");
                        break;
                    case "s":
                        if (departmentsList.isEmpty()) {
                            System.out.println("Doesn't have any elements.");
                        } else {
                            System.out.println(departmentsList.size() + " elements.");
                        }
                        System.out.println("Enter comand again: ");
                        break;
                    case "%":
                        System.out.print("Enter index of element: ");
                        int indexToPer = scanner.nextInt();
                        System.out.println(departmentsList.get(indexToPer).persentDeviationsFromPlan());
                        System.out.println("Enter comand again: ");
                        break;
                    case "k":
                        System.out.print("Enter index of element: ");
                        int indexToHour = scanner.nextInt();
                        System.out.println(departmentsList.get(indexToHour).hourDeviationsFromPlan());
                        System.out.println("Enter comand again: ");
                        break;
                    case "e":
                        finishOfProgram();
                        break;
                    default:
                        System.out.println("Enter correct comand: \n");
                        break;
                }
            }
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
