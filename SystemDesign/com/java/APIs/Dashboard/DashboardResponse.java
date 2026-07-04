package SystemDesign.com.java.APIs.Dashboard;

public class DashboardResponse {
    private User user;
    private Payment payment;
    private Reward reward;

    public DashboardResponse(User user,
                             Payment payment,
                             Reward reward) {
        this.user = user;
        this.payment = payment;
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "\nDashboardResponse\n" +
                "-----------------\n" +
                user + "\n" +
                payment + "\n" +
                reward;
    }
}
