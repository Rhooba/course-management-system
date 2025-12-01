<<<<<<< Updated upstream:src/main/java/com/cms/backend/Instructor.java
package com.cms.backend;

import java.util.*;
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes:src/main/java/com/cms/backend/Professor.java

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

    public String getInfo() {
        return String.format("Professor: %s (%s) | Email: %s | Phone: %d | Courses: %d | Assignments: %d",
                name, username, email, PhoneNumber, courses.size(), assignments.size());
    }
}