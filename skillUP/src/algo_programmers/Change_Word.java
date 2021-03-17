package algo_programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Change_Word {
    static int count = 0;

    public static void main(String[] args) {
        String[] words = {"7800", "7890", "7899"};
        System.out.println(solution("7000", "7899", words));
    }

    public static int solution(String begin, String target, String[] words) {

        ArrayList<String> wordsList = new ArrayList(Arrays.asList(words));
        if(!wordsList.contains(target)) {
            return 0;
        }

        dfs(begin, target, wordsList);
        return count;
    }

    public static void dfs(String begin, String target, ArrayList<String> wordsList) {
        count++;
        if(wordsList.contains(begin)) {
            wordsList.remove(begin);
        }

        String temp = "";

        int tempCnt = 0;
        for(int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) == target.charAt(i)) {
                tempCnt ++;
            }
        }

        if(begin.length()-1 != tempCnt) {
            for(String word : wordsList) {
                int cnt = 0;
                for (int i = 0; i < begin.length(); i++) {
                    if (word.charAt(i) == begin.charAt(i)) {
                        cnt++;
                    }
                }

                if (begin.length() - 1 == cnt) {
                    temp = word;
                    break;
                }
            }
        }

        if(!wordsList.isEmpty() && !temp.isEmpty() && !temp.equals(target)) {
            dfs(temp, target, wordsList);
        }
    }
}
