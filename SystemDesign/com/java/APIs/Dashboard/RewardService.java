package SystemDesign.com.java.APIs.Dashboard;

public class RewardService {
    public Reward getReward(Long id) {

        sleep(3000);

        System.out.println(Thread.currentThread().getName() + " -> Reward Service");

        return new Reward(250);
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
