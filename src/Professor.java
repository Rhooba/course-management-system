import java.util.*;

public class Professor extends User {
    private List<Assignment> assignments = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public Professor(String username, String name, String email, int PhoneNumber) {
        super(username, name, email, PhoneNumber);
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