package algo_leetcode.easy;

public class Length_of_Last_Word {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }

    public static int lengthOfLastWord(String s) {
        String[] temp = s.split(" ");
        return temp[temp.length-1].length();
    }
}
