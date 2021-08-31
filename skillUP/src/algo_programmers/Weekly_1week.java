package algo_programmers;

public class Weekly_1week {
    public static void main(String[] args) {
        System.out.println(solution(10000, 10000, 15));
    }

    public static long solution(int price, int money, int count) {
        long sum = 0;

        for(int i = 1; i <= count; i++) {
            sum += price * i;
        }

        return Math.max(sum - money, 0);
    }
}
