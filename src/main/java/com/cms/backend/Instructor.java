package com.cms.backend;

import java.util.*;

public class Instructor extends User {
    private List<Assignment> assignments = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Instructor(String username, String name, String email, int phoneNumber) {
        super(username, name, email, phoneNumber);
    }

    public void viewGrade(Student student) {
        student.viewGrade();
    }

    public void enterGrade(Student student, Grade grade) {
        student.addGrade(grade);
    }

    public void exportFile(Student student) {
        student.exportGrade();
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
}