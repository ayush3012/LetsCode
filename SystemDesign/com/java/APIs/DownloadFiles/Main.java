package SystemDesign.com.java.APIs.DownloadFiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        FileDownloader downloader = new FileDownloader();

        List<CompletableFuture<String>> futures = new ArrayList<>();

        long start = System.currentTimeMillis();

        // Submit 10 download tasks
        for (int i = 1; i <= 10; i++) {

            String file = "File-" + i;

            CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> downloader.download(file), executor)
                            .orTimeout(5, TimeUnit.MILLISECONDS)
                            .exceptionally(ex->{
                                System.out.println(file+" failed");

                                return file+" FAILED";
                            });

            futures.add(future);
        }

        // Wait for all downloads : allOf waits for all file to be downloaded
        CompletableFuture<Void> all = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        all.join();

        // Print results
        futures.stream().map(CompletableFuture::join).forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.println("\nTotal Time : " + (end - start) + " ms");

        executor.shutdown();
    }

}
