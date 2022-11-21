package algo_leetcode.easy;

import java.util.Arrays;

public class Valid_Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("nagaram", "anagram"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        if(Arrays.equals(sArr, tArr)) {
            return true;
        }

//        for(int i = 0; i < s.length(); i++) {
//            if(sArr[i] != tArr[i]) return false;
//        }

        return false;
    }
}
