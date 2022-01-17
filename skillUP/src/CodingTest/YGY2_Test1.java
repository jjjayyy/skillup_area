package CodingTest;

public class YGY2_Test1 {

    public static void main(String[] args) {
        System.out.println(solution(125));
    }

    static int solution(int N) {
        int length = (int)(Math.log10(N)+1);

        int result = 1;
        for(int i = 1; i < length; i++) {
            result *= 10;
        }

        return  result == 1 ? 0 : result;
    }
}
