package algo_hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A_Very_Big_Sum {

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {

        return Arrays.stream(ar).reduce((a, b) -> a + b).getAsLong();

    }

    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(list.size());

    }

}
