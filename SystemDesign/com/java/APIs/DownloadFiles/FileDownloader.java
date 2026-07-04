package SystemDesign.com.java.APIs.DownloadFiles;

public class FileDownloader {

    public String download(String fileName) {

        System.out.println(Thread.currentThread().getName() + " Started downloading " + fileName);

        try {
            Thread.sleep(3000); // simulate download
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println(Thread.currentThread().getName() + " Finished downloading " + fileName);

        return fileName + " Downloaded";
    }
}
