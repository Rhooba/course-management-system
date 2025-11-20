import java.util.*;

public class Student extends User {
    private List<Grade> grades = new ArrayList<>();
    private double average;

    public Student(String username, String name, String email, int PhoneNumber) {
        super(username, name, email, PhoneNumber);
    }

    public void viewGrade() {
        for (Grade g : grades) System.out.println(g);
    }

    public void exportGrade() {
        // Write grades to a file
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
}