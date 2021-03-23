package algo_programmers;

public class Make_Large_Number {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }

    public static String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);

        int left = 0;
        int right = number.length() - k;
        int max = -1;
        int prevMaxIdx = -1;

        while(builder.length() > right) {

            for(int i = left; i < k; i++) {
                int num = builder.charAt(i) - '0';
                if(max < num) {
                    max = num;
                    if(prevMaxIdx != -1) builder.deleteCharAt(prevMaxIdx);
                    prevMaxIdx = i;
                }
            }
        }
        return builder.toString();
    }

}
