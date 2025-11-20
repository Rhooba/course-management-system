public class Grade {
    private String assignmentName;
    private double score;
    private double maxPoints;

    public Grade(String assignmentName, double score, double maxPoints) {
        this.assignmentName = assignmentName;
        this.score = score;
        this.maxPoints = maxPoints;
    }

    public double getPercentage() {
        return (score / maxPoints) * 100;
    }

    @Override
    public String toString() {
        return assignmentName;
    }
}