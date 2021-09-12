package algo_programmers;

public class Next_Large_Number {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {
        int largerN = n+1;
        int nBinary = Integer.bitCount(n);
        int largerNBinary = Integer.bitCount(largerN);

        while(nBinary != largerNBinary) {
            largerN = largerN + 1;
            largerNBinary = Integer.bitCount(largerN);
        }
        System.out.println(largerN);
        return largerN;
    }
}
