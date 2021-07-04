package CodingTest;

public class NWT_Test3 {
    public static void main(String[] args) {
        String s = "aaccs";
        String t = "ab";

        System.out.println(solution(s, t));
    }


    public static int solution(String s, String t) {
        int result = 0;

        while(s.contains(t)) {
            s = s.replace(t, "");
            result++;
        }

        return result;
    }
}
