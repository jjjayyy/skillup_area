package algo_programmers;

import java.util.ArrayList;
import java.util.List;

public class Eng_Last_word {

    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        solution(2, words);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        List<String> sayWords = new ArrayList<>();
        answer[0] = 0;
        answer[1] = 0;

        for(int i = 0; i < words.length; i++) {
            if(!sayWords.isEmpty()) {
                String prevWord = sayWords.get(sayWords.size()-1);
                if((sayWords.contains(words[i]) || words[i].charAt(0) != prevWord.charAt(prevWord.length()-1))) {
                    int num = (i+1) %  n;
                    int cnt = (i+1) / n;
                    answer[0] = num == 0 ? n : num;
                    answer[1] = num == 0 ? cnt : cnt + 1;
                    break;
                }
            }

            sayWords.add(words[i]);
        }

        System.out.println(answer[0]);
        System.out.println(answer[1]);
        return answer;
    }
}
