package algo_leetcode;

public class Reverse_String {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        char[] temp = s.clone();

        for(int i = 0; i < s.length; i++) {
            s[i] = temp[s.length-1-i];
        }
    }
}
