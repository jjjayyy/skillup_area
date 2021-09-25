package algo_leetcode;

public class Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("ab_a"));
    }

    public static boolean isPalindrome(String s) {
        String temp = s.replaceAll("\\W","").replaceAll("_","").toLowerCase();
        System.out.println(temp);
        for(int i = temp.length()-1; i >= 0; i--) {
            if(temp.charAt(i) !=  temp.charAt(temp.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
