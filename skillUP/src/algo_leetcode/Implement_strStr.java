package algo_leetcode;

public class Implement_strStr {

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.isEmpty()) {
            return 0;
        }

        if(haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }
}
