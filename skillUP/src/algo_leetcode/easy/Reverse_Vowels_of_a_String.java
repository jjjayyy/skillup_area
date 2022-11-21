package algo_leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_Vowels_of_a_String {

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {
        String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};
        List<String> list = Arrays.asList(vowels);
        Queue<String> q = new LinkedList<>();

        for(int i = s.length()-1; i >= 0; i--) {
            String temp = s.charAt(i)+"";
            if(list.contains(temp)) {
                q.add(temp);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(list.contains(s.charAt(i)+"")) {
                stringBuilder.append(q.poll());
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

}
