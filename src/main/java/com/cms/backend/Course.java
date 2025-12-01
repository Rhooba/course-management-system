package com.cms.backend;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private int courseNumber;
    private String instructor;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, int courseNumber, String instructor) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.instructor = instructor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayRoster() {
        for (Student s: students) {
            System.out.println(s.getName() + " - " + s.getEmail());
        }
    }

    public void displayCourse() {
        System.out.println("Course: " + courseName + " (" + courseNumber + ")");
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled students: " + students.size());
        if (!students.isEmpty()) {
            System.out.println("Roster:");
            displayRoster();
        }
    }
}