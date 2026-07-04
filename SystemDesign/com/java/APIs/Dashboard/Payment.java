package SystemDesign.com.java.APIs.Dashboard;

public class Payment {
    private Long userId;
    private double amount;

    public Payment(Long userId, double amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Payment{amount=" + amount + "}";
    }
}
