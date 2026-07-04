package SystemDesign.com.java.APIs.Dashboard;

public class PaymentService {
    public Payment getPayment(Long id) {

        sleep(3000);

        System.out.println(Thread.currentThread().getName() + " -> Payment Service");

        return new Payment(id, 5000);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
