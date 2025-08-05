package org.social.controller;

import org.social.service.StudentService;

import java.util.Scanner;

public class StudentController {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentService studentService = new StudentService();

    public void run() {
        while (true) {
            printMenu();
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    studentService.printAllStudents();
                    break;
                case "3":
                    findStudentById();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n---  ---");
        System.out.println("1. POST /students       ");
        System.out.println("2. GET /students        ");
        System.out.println("3. GET /students/{id}   ");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    private void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        studentService.addStudent(name, age);
    }

    private void findStudentById() {
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        studentService.findStudentById(id);
    }
}
