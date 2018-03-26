package words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        Map<String, Integer> wordStat = new HashMap<>();
        try {
            String currentLine;
            BufferedReader br = new BufferedReader(new FileReader("testing.txt"));
            while ((currentLine = br.readLine()) != null) {
                for (String word : currentLine.split("[.,\\s]")) {
                    if (word.isEmpty())
                        continue;
                    int count = wordStat.getOrDefault(word, 0);
                    wordStat.put(word, ++count);
                }
            }
            wordStat.entrySet().stream()
                    .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                    .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
