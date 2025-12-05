package com.cms.backend;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;




public class Student extends User {
    private List<Grade> grades = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private double average;

    public Student(String username, String name, String email, int phoneNumber) {
        super(username, name, email, phoneNumber);
    }

    public void viewGrade() {
        for (Grade g : grades) System.out.println(g);
    }

    public boolean exportGrade() {
        String filename = String.format("grades_%s.txt", username);
        File file = new File(filename);
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            pw.println("Grades for: " + name + " (" + username + ")");
            pw.println("Email: " + email + " | Phone: " + phoneNumber);
            pw.println();

            // pw.println("Grades for: " + name + " (" + username + ")");
            // pw.println("Email: " + email + " | Phone: " + phoneNumber);
            // pw.println();
            if (grades.isEmpty()) {
                pw.println("No grades available.");
            }   else {
                pw.println(String.format("%-30s %-10s", "Assignment", "Percent"));
                for (Grade g : grades) {
                    String a = g.toString();
                   // pw.println(String.format("%-30s %-10s", a, String.format("%.2f%%", g.getPercentage())));
                }
                double avg = calculateAverage();
               // pw.println();
                //pw.println(String.format("Average: %.2f%%", avg));
                //pw.println("Letter Grade: " + getLetterGrade());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double total = 0;
        for (Grade g : grades) total += g.getPercentage();
        average = total / grades.size();
        return average;
    }

    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

    public void addGrade(Grade grade) { grades.add(grade); }

    public String getInfo() {
        double avg = calculateAverage();
        String letter = getLetterGrade();
        return String.format("Student: %s (%s) | Email: %s | Phone: %d | Average: %.2f%% (%s)",
                name, username, email, phoneNumber, avg, letter);
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAverageGrade() {
        double avg = calculateAverage();
        String letter = getLetterGrade();
        System.out.println(String.format("Average Grade: %.2f%% (%s)", avg, letter));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourse() {
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Course c : courses) {
                System.out.println("  - " + c.getCourseName());
            }
        }
    }
}