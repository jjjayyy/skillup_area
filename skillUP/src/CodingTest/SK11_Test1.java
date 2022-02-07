package CodingTest;

public class SK11_Test1 {

    public static void main(String[] args) {
        solution(130);
    }

    static public int solution(int N) {
        int sumDigitByN = getSumDigit(N);
        int result = N+1;

        while(sumDigitByN != getSumDigit(result)) {
            result++;
        }
        return result;
    }

    private static int getSumDigit(int digit) {
        int sum = 0;
        while (digit > 0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }
}
