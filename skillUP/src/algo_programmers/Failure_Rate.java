package algo_programmers;

import java.util.*;

public class Failure_Rate {

    public static  int[] solution(int N, int[] stages) {

        Map<Integer, Integer> notClearNum = new HashMap<>();
        Map<Integer, Double> failureRate = new HashMap<>();

        //stage별 못 클리어한 사람 수 구분
        for(int stage : stages) {
            int cnt = notClearNum.containsKey(stage) ? notClearNum.get(stage) + 1 : 1;
            notClearNum.put(stage, cnt);
        }

        //stage별 실패율
        int totalNum = stages.length;
        for(int i = 1; i <= N; i++) {
            if(notClearNum.containsKey(i)) {
                int cnt = notClearNum.get(i);
                failureRate.put(i, (double) cnt / totalNum);
                totalNum -= cnt;
            } else {
                failureRate.put(i, 0.0);
            }
        }

        List<Integer> result = sort(failureRate);
        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static List<Integer> sort(Map<Integer, Double> map) {
        List<Integer> result = new ArrayList<>();
        result.addAll(map.keySet());
        Collections.sort(result, (Comparator) (o1, o2) -> {
            return ((Comparable) map.get(o2)).compareTo(map.get(o1));
        });
        return result;
    }

    public static void main(String[] args) {


        int[] arr = {2, 1, 2, 6, 2, 4, 3, 3};
        for(int a : solution(5, arr)) {
            System.out.println(a);
        }
    }

}
