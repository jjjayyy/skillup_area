package algo_leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Word_Pattern {
    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat dog");
    }

    public static boolean wordPattern(String pattern, String s) {

        Map<String, String> wordMap = new HashMap<>();
        String[] wordArr = s.split(" ");

        if(pattern.length() != wordArr.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            String patternStr = pattern.charAt(i) + "";

            if(!wordMap.containsKey(patternStr)) {
                wordMap.put(patternStr, wordArr[i]);
            }

            if(!wordArr[i].equals(wordMap.getOrDefault(patternStr, "EMPTY WORD"))) {
                return false;
            }
        }

        Map<String, Integer> distinctMap = new HashMap<>();
        for(String key : wordMap.keySet()) {
            distinctMap.put(wordMap.get(key), 0);
        }
        return wordMap.size() == distinctMap.size();
    }
}
