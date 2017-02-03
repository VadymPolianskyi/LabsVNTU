package com.company.OOP.lab2;

import java.util.Scanner;

public class Main {

    private static boolean workOfProgram = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String comand;
        DepartmentsList departmentsList = new DepartmentsList();

        System.out.println("Enter to run:\n" +
                "'a' - add Department time\n" +
                "'d' - display all Departments\n" +
                "'c' - clear all Departments\n" +
                "'r' - remove Departmen\n" +
                "'g' - get departmen to index\n" +
                "'n' - get departmen to name\n" +
                "'p' - display all plan hours from all Departments\n" +
                "'f' - display all fact hours from all Departments\n" +
                "'s' - display count of Departments\n" +
                "'%' - display deviations from plan in %\n" +
                "'k' - display deviations from plan in kW/h\n" +
                "'e' - exit");

        while (workOfProgram) {
            comand = scanner.nextLine();
            if (checkComand(comand)) {
                switch (comand) {
                    case "a":
                        System.out.print("Enter Departman name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter fact hours: ");
                        int factHours = scanner.nextInt();
                        System.out.print("Enter plan hours: ");
                        int planHours = scanner.nextInt();
                        departmentsList.add(new Department(planHours, factHours, name));
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
                        System.out.print("Enter index of Departmen: ");
                        int indexToGet = scanner.nextInt();
                        System.out.println(departmentsList.get(indexToGet));
                        System.out.println("Enter comand again: ");
                        break;
                    case "n":
                        System.out.print("Enter name of Departmen: ");
                        String nameGet = scanner.nextLine();
                        Department curentDep = departmentsList.get(nameGet);
                        if (curentDep == null) {
                            System.out.println("Can't find this departmen...");
                        } else {
                            System.out.println(curentDep);
                        }
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
                        System.out.print("Enter name of Departmen: ");
                        String nameGet1 = scanner.nextLine();
                        Department curentDep1 = departmentsList.get(nameGet1);
                        if (curentDep1 == null) {
                            System.out.println("Can't find this departmen...");
                        } else {
                            System.out.println(departmentsList.get(nameGet1).persentDeviationsFromPlan());
                        }
                        System.out.println("Enter comand again: ");
                        break;
                    case "k":
                        System.out.print("Enter name of Departmen: ");
                        String nameGet2 = scanner.nextLine();
                        Department curentDep2 = departmentsList.get(nameGet2);
                        if (curentDep2 == null) {
                            System.out.println("Can't find this departmen...");
                        } else {
                            System.out.println(departmentsList.get(nameGet2).hourDeviationsFromPlan());
                        }
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
