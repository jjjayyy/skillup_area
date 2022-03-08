package algo_hackerrank.easy;

public class Repeated_String {
    public static void main(String[] args) {
        System.out.println(repeatedString("a", 1000000000000L));
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long repeatCnt =  n / s.length();
        long addCnt =  n % s.length();

        long aCnt = 0;
        long addACnt = 0;
        for(int i = 0; i < s.length(); i++){
            if('a' == s.charAt(i)) aCnt++;
            if(addCnt - 1 == i) addACnt = aCnt;
        }

        return aCnt * repeatCnt + addACnt;
    }
}
