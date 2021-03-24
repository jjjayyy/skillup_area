package algo_programmers;

public class Make_Large_Number {
    public static void main(String[] args) {
        System.out.println(solution("4177252841", 8));
    }

    public static String solution(String number, int k) {
        StringBuilder builder = new StringBuilder(number);

        int left = 0;
        int right = k;
        int prevNum = -1;

        while(builder.length() > number.length() - k) {
            left = 0;
            for(int i = left; i < right; i++) {
                int num = builder.charAt(i) - '0';
                if(num == 9) {

                }
                if(prevNum < num) {
                    if(prevNum != -1 && i > 0) {
                        builder.deleteCharAt(i-1);
                        i--;
                        right--;
                    }
                } else {
                    left = i;
                }
                prevNum = num;
            }

            if(builder.length() > right) {
                right++;
            } else {
                builder.deleteCharAt(builder.length()-1);
                builder.delete(number.length()-k-1, builder.length()-1);
            }
        }
        return builder.toString();
    }

}
