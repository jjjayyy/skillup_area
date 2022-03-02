package algo_leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Pascal_Triangle {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> tempList;

        for(int i = 0; i < numRows; i++) {
            tempList = new ArrayList<>();

            for(int j = 0; j <= i; j++) {
                int temp = 1;
                if(j > 0 && j < i) {
                    temp = resultList.get(i-1).get(j-1) + resultList.get(i-1).get(j);
                }
                tempList.add(temp);
            }
            resultList.add(tempList);
        }

        return resultList;
    }
}
