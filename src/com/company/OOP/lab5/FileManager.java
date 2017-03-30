package com.company.OOP.lab5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
//    work with file "employees.txt"

    private static String fileName;
    private static Path file;

    public static void setFileName(String fileName) {
        if (!fileName.endsWith(".txt")) {
            fileName += ".txt";
        }
        FileManager.fileName = fileName;

        file = Paths.get(fileName);

        try {
            Files.createFile(file);
        } catch (IOException e) {
            System.out.println("file is already created");
        }
    }


    public static void writeDepartamentsToFile(DepartmentsList departmentsList) {
//        writing list of "employees" to file
        try {
            FileOutputStream fo = new FileOutputStream(new File(fileName));
            ObjectOutputStream serial = new ObjectOutputStream(fo);
            serial.writeObject(departmentsList);
            serial.flush();
        } catch (IOException ex) {
            System.out.println("Error object serialization");
        }

    }

    public static DepartmentsList readDepartamentsFromFile() {
//        reading list of "employees" from file
        try {
            FileInputStream bais = new FileInputStream(new File(fileName));
            ObjectInputStream ois = new ObjectInputStream(bais);

            Object obj = ois.readObject();
            ois.close();
            bais.close();
            return (DepartmentsList) obj;
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            System.out.println("Exception in readDepartamentsFromFile");
        }

        return null;
    }

    public static void addDeparture(Department department) {
        DepartmentsList departmentsList = readDepartamentsFromFile();

        departmentsList.add(department);
        writeDepartamentsToFile(departmentsList);
    }
}
