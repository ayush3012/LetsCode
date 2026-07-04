package SystemDesign.com.java.DashBoardAPI;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DashboardService {
    private final UserService userService = new UserService();
    private final PaymentService paymentService = new PaymentService();
    private final RewardService rewardService = new RewardService();

    private final ExecutorService executor =
            Executors.newFixedThreadPool(3);

    public DashboardResponse getDashboard(Long id) {

        CompletableFuture<User> userFuture =
                CompletableFuture.supplyAsync(
                        () -> userService.getUser(id),
                        executor);

        CompletableFuture<Payment> paymentFuture =
                CompletableFuture.supplyAsync(
                        () -> paymentService.getPayment(id),
                        executor);

        CompletableFuture<Reward> rewardFuture =
                CompletableFuture.supplyAsync(
                        () -> rewardService.getReward(id),
                        executor);

        CompletableFuture<Void> all =
                CompletableFuture.allOf(
                        userFuture,
                        paymentFuture,
                        rewardFuture);

        return all.thenApply(v ->
                        new DashboardResponse(
                                userFuture.join(),
                                paymentFuture.join(),
                                rewardFuture.join()))
                .join();
    }

    public void shutdown() {
        executor.shutdown();
    }
}
