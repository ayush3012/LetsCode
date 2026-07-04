package SystemDesign.com.java.APIs.Dashboard;

public class Reward {
    private int points;

    public Reward(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Reward{points=" + points + "}";
    }
}
