package algo_programmers;

public class Number_Expression {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {
        int limit = n / 2 + n % 2;
        int cnt = 1;

        for(int i = 1; i <= limit; i++) {
            int temp = n;
            for(int j = i; j <= limit; j++) {
                temp -= j;
                if(temp <= 0) {
                    break;
                }
            }

            if(temp == 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
