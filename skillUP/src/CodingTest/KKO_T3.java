package CodingTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KKO_T3 {
    public static void main(String[] args) {
        int[] arr ={2, 5, 2, 7,8, 4};  // 3
//        int[] arr ={2, 5, 3, 1};    // 2
        List<Integer> cards = Arrays.stream(arr).boxed().collect(Collectors.toList());

        System.out.println(solution(cards));
    }

    public static int solution(List<Integer> cards) {
        int[] dpBySum = createDpBySum(cards);
        int sizeByOdd = cards.size() - 1 - (cards.size() % 2);
        int sizeByEven = cards.size() - 2 + (cards.size() % 2);

        if(dpBySum[sizeByOdd] == dpBySum[sizeByEven]
        || dpBySum[sizeByOdd] == dpBySum[sizeByEven] - cards.get(0)) {
            return -1;
        }

        for(int i = 1; i < cards.size(); i++) {
            int missingCard = cards.get(i);
            int keroNums = 0;
            int beroniNums = 0;

            if(i % 2 == 0) {
                beroniNums = dpBySum[i] + dpBySum[sizeByOdd] - dpBySum[i-1] - missingCard;
                keroNums = dpBySum[i-1] + dpBySum[sizeByEven] - dpBySum[i];
            } else {
                keroNums = dpBySum[i] + dpBySum[sizeByEven] - dpBySum[i-1] - missingCard;
                beroniNums = dpBySum[i-1] + dpBySum[sizeByOdd] - dpBySum[i];
            }

            if(keroNums == beroniNums) {
                return i+1;
            }
        }
        return -1;
    }

    private static int[] createDpBySum(List<Integer> cards) {
        int[] dpBySum = new int[cards.size()];
        for(int i = 0; i < cards.size(); i++) {
            dpBySum[i] = cards.get(i);
            if(i > 1) {
                dpBySum[i] += dpBySum[i-2];
            }
        }
        return dpBySum;
    }

}
