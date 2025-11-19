package com.cms.ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Course Management System");
        
        // TODO: Initialize Backend Services (Authentication, etc.)
        
        boolean running = true;
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    login(scanner);
                    break;
                case "2":
                    running = false;
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    
    private static void login(Scanner scanner) {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // TODO: Call AuthenticationService from backend
        // Temporary mock login for testing the UI
        if (username.equalsIgnoreCase("instructor")) {
            System.out.println("Login successful. Welcome, Instructor.");
            showInstructorMenu(scanner);
        } else if (username.equalsIgnoreCase("student")) {
            System.out.println("Login successful. Welcome, Student.");
            // showStudentMenu(scanner); // To be implemented
        } else {
            System.out.println("Invalid credentials. (Hint: try 'instructor' or 'student')");
        }
    }

    private static void showInstructorMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Instructor Menu ---");
            System.out.println("1. Add Student to Roster");
            System.out.println("2. Add Assignment");
            System.out.println("3. Record Student Grade");
            System.out.println("4. View All Grades and Averages");
            System.out.println("5. Export Student Grade File");
            System.out.println("6. Logout");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    addAssignment(scanner);
                    break;
                case "3":
                    recordGrade(scanner);
                    break;
                case "4":
                    viewGrades(scanner);
                    break;
                case "5":
                    exportGrades(scanner);
                    break;
                case "6":
                    back = true;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.println("\n[Add Student]");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Email: ");
        String email = scanner.nextLine();
        // TODO: Call backend to save student
        System.out.println("Student '" + name + "' added (placeholder).");
    }

    private static void addAssignment(Scanner scanner) {
        System.out.println("\n[Add Assignment]");
        System.out.print("Enter Assignment Name: ");
        String assignName = scanner.nextLine();
        System.out.print("Enter Max Points: ");
        String maxPoints = scanner.nextLine();
        // TODO: Call backend to save assignment
        System.out.println("Assignment '" + assignName + "' added (placeholder).");
    }

    private static void recordGrade(Scanner scanner) {
        System.out.println("\n[Record Grade]");
        System.out.print("Enter Student ID/Name: ");
        String student = scanner.nextLine();
        System.out.print("Enter Assignment Name: ");
        String assignment = scanner.nextLine();
        System.out.print("Enter Score: ");
        String score = scanner.nextLine();
        // TODO: Call backend to save grade
        System.out.println("Grade recorded (placeholder).");
    }

    private static void viewGrades(Scanner scanner) {
        System.out.println("\n[View Grades]");
        // TODO: Call backend to get all grades
        System.out.println("Displaying all grades... (placeholder)");
    }

    private static void exportGrades(Scanner scanner) {
        System.out.println("\n[Export Grades]");
        System.out.print("Enter Student Name to export: ");
        String student = scanner.nextLine();
        // TODO: Call backend to export file
        System.out.println("Exporting grades for " + student + "... (placeholder)");
    }
}
