package com.cms.backend;

import java.util.*;

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
}