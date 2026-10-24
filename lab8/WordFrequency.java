package lab8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordFrequency {
    public static void main(String[] args) {
        String sentence = "the quick brown fox jumps over the lazy dog the fox";
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : sentence.split(" ")) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println("Word Frequencies (Highest to Lowest):");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
