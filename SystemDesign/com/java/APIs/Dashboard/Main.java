package SystemDesign.com.java.APIs.Dashboard;

public class Main {

    public static void main(String[] args) {

        DashboardService dashboardService = new DashboardService();

        long start = System.currentTimeMillis();

        DashboardResponse response = dashboardService.getDashboard(101L);

        long end = System.currentTimeMillis();

        System.out.println(response);

        System.out.println("\nTime Taken = " + (end - start) + " ms");

        dashboardService.shutdown();
    }
}
