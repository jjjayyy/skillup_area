package CodingTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class KKO_T2 {
    public static void main(String[] args) {
        Float[] floArr = {1.4f, 1.01f, 2.4f, 1.01f, 1.01f};   //3
//        Float[] floArr = {1.4f, 1.991f, 1.01f, 1.32f};      //3

        List<Float> weight = Arrays.stream(floArr).collect(Collectors.toList());
        solution(weight);
    }

    public static int solution(List<Float> weight) {
        boolean[] isVisited = new boolean[weight.size()];
        Collections.sort(weight);

        int moveCnt = 0;
        int visitCnt = 0;
        int maxIdx = weight.size();

        while(visitCnt < weight.size()) {
            maxIdx = findByMaxIdx(maxIdx, isVisited);
            int prevIdx = -1;
            for(int i = 0; i < maxIdx; i++) {
                if(!isVisited[i] && weight.get(i) + weight.get(maxIdx) <= 3) {
                    prevIdx = i;
                    continue;
                }
                break;
            }
            if(prevIdx >= 0) {
                isVisited[prevIdx] = true;
                visitCnt++;
            }
            visitCnt++;
            moveCnt++;
        }
        System.out.println(moveCnt);
        return moveCnt;
    }

    private static int findByMaxIdx(int maxIdx, boolean[] isVisited) {
        for(int i = maxIdx; i >= 0; i--) {
            if(!isVisited[i-1]) {
                maxIdx = i - 1;
                isVisited[maxIdx] = true;
                break;
            }
        }
        return  maxIdx;
    }
}
