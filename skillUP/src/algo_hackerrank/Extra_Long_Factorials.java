package algo_hackerrank;

import java.math.BigInteger;

public class Extra_Long_Factorials {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger bigN = BigInteger.valueOf(n);

        for(int i = 1; i < n; i++) {
            bigN = bigN.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigN);
    }

    public static void main(String[] args) {
        extraLongFactorials(100);
    }

}
