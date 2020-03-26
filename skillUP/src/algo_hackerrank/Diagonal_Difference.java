package algo_hackerrank;

import java.util.List;

public class Diagonal_Difference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int leftRight = 0;
        int rightLeft = 0;

        for(int i = 0; i < arr.get(0).size(); i++) {
            leftRight += arr.get(i).get(i);
            rightLeft += arr.get(i).get(arr.get(0).size() - 1 - i);
        }

        return Math.abs(leftRight - rightLeft);

    }
}
