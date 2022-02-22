package algo_leetcode.easy;

public class Palindrome_Number {
    public static void main(String[] args) {
        System.out.println(isPalindrome(122454221));
    }

    public static boolean isPalindrome(int x) {
        String parseX = String.valueOf(x);

        for(int i = 0; i < parseX.length(); i++) {
            int lastIdx = parseX.length()-1-i;
            if(i != lastIdx && parseX.charAt(i) != parseX.charAt(lastIdx)) {
                return false;
            }
        }
        return true;
    }
}
