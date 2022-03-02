package algo_leetcode.medium;

public class Longest_Palindromic_Substring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }

    static int startIdx = 0;
    static int maxLen = 0;
    public static String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        for(int i = 0; i < s.length(); i++) {
            findLengthPalindrome(s, i, i);
            findLengthPalindrome(s, i, i+1);
        }

        return s.substring(startIdx, startIdx + maxLen);
    }

    private static void findLengthPalindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        if(maxLen < j - i - 1) {
            startIdx = i + 1;
            maxLen = j - i - 1;
        }
    }
}
