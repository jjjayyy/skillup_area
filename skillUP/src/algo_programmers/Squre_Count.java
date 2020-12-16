package algo_programmers;

public class Squre_Count {

    public static long solution(int w, int h) {

        long max = gcd(w, h);
        long sqrCrossLine = (w/max + h/max - 1) * max;

        return w * h - sqrCrossLine;
    }

    private static long gcd(int num1, int num2) {
        int temp;
        while(num2 > 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(solution(12, 8));
    }


}
