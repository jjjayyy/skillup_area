package algo_programmers;

public class Make_Large_Number {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }

    public static String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);

        int resultLength = number.length() - k;
        while(builder.length() > resultLength) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

}
