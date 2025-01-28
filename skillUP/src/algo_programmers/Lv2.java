package algo_programmers;

import java.util.HashMap;
import java.util.Map;

public class Lv2 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer,Integer> firstMap = new HashMap<>();
        Map<Integer,Integer> tempMap = new HashMap<>();
        int firstCnt = 0;
        int tempCnt = 0;

        for(int i = 1; i < topping.length; i++) {
            if(!tempMap.containsKey(topping[i])) {
                tempCnt++;
            }
            tempMap.put(topping[i],tempMap.getOrDefault(topping[i],0) + 1);
        }

        for(int i = 0; i < topping.length-1; i++){
            if(!firstMap.containsKey(topping[i])) {
                firstMap.put(topping[i], 1);
                firstCnt++;
            }

            if(i > 0) {
                tempMap.put(topping[i], tempMap.get(topping[i])-1);
                if(tempMap.get(topping[i]) == 0) {
                    tempCnt--;
                }
            }
            if(firstCnt == tempCnt) {
                answer++;
            }
        }
        return answer;
    }
}
