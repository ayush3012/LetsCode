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

        String regex="[^\\p{L}\\p{N}]+";

        /*
        * \p{L}= any unicode letter (english,hindi or any language)
        * \p{N}= any unicode number
        * [^...] = anything that is not a letter or number
        * + = one or more separator
        * */

        try(BufferedReader br= Files.newBufferedReader(Paths.get("file.txt")))
        {
            String line;

            while ((line=br.readLine())!=null)
            {
                String[] words=line.toLowerCase().split(regex);

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
