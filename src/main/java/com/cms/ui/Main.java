package com.cms.ui;

import com.cms.backend.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Backend service instances
    private static AuthenticationService authService;
    private static List<Student> students;
    private static List<Instructor> instructors;
    private static List<Assignment> assignments;
    private static List<Course> courses;
    
    public static void main(String[] args) {
        // Initialize Backend Services
        authService = new AuthenticationService();
        students = new ArrayList<>();
        instructors = new ArrayList<>();
        assignments = new ArrayList<>();
        courses = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Course Management System");
        
        // Load data from files (TODO: implement file loading)
        
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
        
        // Use AuthenticationService to validate credentials
        boolean isAuthenticated = authService.login(username, password);
        
        if (isAuthenticated) {
            // Determine user role and show appropriate menu
            // TODO: Get user role from AuthenticationService
            // For now, using temporary logic
            if (username.equalsIgnoreCase("instructor")) {
                System.out.println("Login successful. Welcome, Instructor.");
                showInstructorMenu(scanner);
            } else if (username.equalsIgnoreCase("student")) {
                System.out.println("Login successful. Welcome, Student.");
                showStudentMenu(scanner);
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
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
        System.out.print("Enter Student Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Student Phone Number: ");
        int phoneNumber = Integer.parseInt(scanner.nextLine());
        
        // Create new Student object and add to list
        Student newStudent = new Student(username, name, email, phoneNumber);
        students.add(newStudent);
        
        System.out.println("Student '" + name + "' added successfully.");
        // TODO: Save to users.txt file
    }

    private static void addAssignment(Scanner scanner) {
        System.out.println("\n[Add Assignment]");
        System.out.print("Enter Assignment Name: ");
        String assignName = scanner.nextLine();
        System.out.print("Enter Max Points: ");
        double maxPoints = Double.parseDouble(scanner.nextLine());
        
        // Create new Assignment object and add to list
        Assignment newAssignment = new Assignment(assignName, maxPoints);
        assignments.add(newAssignment);
        
        System.out.println("Assignment '" + assignName + "' added successfully.");
        // TODO: Save to assignments.txt file
    }

    private static void recordGrade(Scanner scanner) {
        System.out.println("\n[Record Grade]");
        
        // Display available students
        if (students.isEmpty()) {
            System.out.println("No students available. Please add students first.");
            return;
        }
        
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Select Student (enter number): ");
        int studentIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }
        
        Student selectedStudent = students.get(studentIndex);
        
        // Display available assignments
        if (assignments.isEmpty()) {
            System.out.println("No assignments available. Please add assignments first.");
            return;
        }
        
        System.out.println("Available Assignments:");
        for (int i = 0; i < assignments.size(); i++) {
            System.out.println((i + 1) + ". " + assignments.get(i).toString());
        }
        System.out.print("Select Assignment (enter number): ");
        int assignmentIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (assignmentIndex < 0 || assignmentIndex >= assignments.size()) {
            System.out.println("Invalid assignment selection.");
            return;
        }
        
        Assignment selectedAssignment = assignments.get(assignmentIndex);
        
        System.out.print("Enter Score: ");
        double score = Double.parseDouble(scanner.nextLine());
        
        // Create Grade object and add to student
        Grade newGrade = new Grade(selectedAssignment.toString(), score, selectedAssignment.getMaxPoints());
        selectedStudent.addGrade(newGrade);
        
        System.out.println("Grade recorded successfully.");
        // TODO: Save to grades.txt file
    }

    private static void viewGrades(Scanner scanner) {
        System.out.println("\n[View Grades]");
        
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        for (Student student : students) {
            System.out.println("\n--- " + student.getName() + " ---");
            student.viewGrade();
            System.out.println("Average: " + String.format("%.2f", student.calculateAverage()) + "%");
            System.out.println("Letter Grade: " + student.getLetterGrade());
        }
    }

    private static void exportGrades(Scanner scanner) {
        System.out.println("\n[Export Grades]");
        
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Select Student to export (enter number): ");
        int studentIndex = Integer.parseInt(scanner.nextLine()) - 1;
        
        if (studentIndex < 0 || studentIndex >= students.size()) {
            System.out.println("Invalid student selection.");
            return;
        }
        
        Student selectedStudent = students.get(studentIndex);
        selectedStudent.exportGrade();
        System.out.println("Exporting grades for " + selectedStudent.getName() + "...");
        // TODO: Implement file export in Student class
    }
    
    private static void showStudentMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Student Menu ---");
            System.out.println("1. View My Grades");
            System.out.println("2. View My Average");
            System.out.println("3. Export My Grades");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n[View Grades - Feature coming soon]");
                    break;
                case "2":
                    System.out.println("\n[View Average - Feature coming soon]");
                    break;
                case "3":
                    System.out.println("\n[Export Grades - Feature coming soon]");
                    break;
                case "4":
                    back = true;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
