package algo_hackerrank.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Sales_by_Match {
    public static void main(String[] args) throws IOException {
        int[] intArr = {1,2,1,2,1,3,2};
        List<Integer> ar = Arrays.stream(intArr).boxed().collect(Collectors.toList());
        sockMerchant(7, ar);
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Integer> validMap = new HashMap<>();
        int socksCnt = 0;
        for(int i = 0; i < ar.size(); i++) {
            int sockCnt = validMap.getOrDefault(ar.get(i), 0) + 1;
            validMap.put(ar.get(i), sockCnt);
            if(sockCnt % 2 == 0 ) {
                socksCnt++;
            }
        }

        System.out.println(socksCnt);
        return socksCnt;
    }
}

