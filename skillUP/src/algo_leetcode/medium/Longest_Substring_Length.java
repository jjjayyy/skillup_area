package algo_leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Length {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {

        Set set = new HashSet();

        int start = 0;
        int end = 0;
        int result = 0;

        while(s.length() > end) {
            if(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            } else {
                set.add(s.charAt(end++));
                result = Math.max(set.size(), result);
            }
        }

        System.out.println(result);
        return result;
    }
}
