public class Assignment {
    private String title;
    private double maxPoints;

    public Assignment(String title, double maxPoints) {
        this.title = title;
        this.maxPoints = maxPoints;
    }

    public double getMaxPoints() {
        return maxPoints;
    }

    @Override
    public String toString() {
        return title;
    }
}