package InterviewProgramming.com.example.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ReadFromFile {

    public static void main(String[] args) throws IOException {

        Map<String,Integer> wordcount=new HashMap<>();

        try(BufferedReader br= Files.newBufferedReader(Paths.get("file.txt")))
        {
            String line;

            while ((line=br.readLine())!=null)
            {
                String[] words=line.toLowerCase().split("^a-zA-Z0-9+");

                for (String word:words)
                {
                    if(!word.isBlank())
                        wordcount.put(word, wordcount.getOrDefault(word,0)+1);
                }
            }
        }
        System.out.println(wordcount);
    }
}
