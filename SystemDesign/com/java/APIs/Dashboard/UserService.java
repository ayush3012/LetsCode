package SystemDesign.com.java.APIs.Dashboard;

public class UserService {
    public User getUser(Long id) {

        sleep(3000);

        System.out.println(Thread.currentThread().getName() + " -> User Service");

        return new User(id, "Ayush");
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
