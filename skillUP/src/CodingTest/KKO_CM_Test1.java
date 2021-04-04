package CodingTest;

import java.util.*;
import java.util.stream.Collectors;

public class KKO_CM_Test1 {
    public static void main(String[] args) {
        int[] girft_cards = {5,4,5,4,5};
        int[] wants = {2, 4, 3, 5, 1};

        int[][] needs = {{1,0,0}, {1,1,0}, {1,1,0}, {1,0,1}, {1,1,0}, {0,1,1}};
       // int[][] needs = {{0,0,1}, {0,1,1}, {0,1,1}, {1,0,1}, {0,1,1}, {1,1,0}};
        int r = 2;

        //System.out.println(solution(girft_cards, wants));
        System.out.println(solution2(needs, r));
    }

    static int solution(int[] gift_cards, int[] wants) {
        int answer = wants.length;
        for(int want : wants) {
            for(int i = 0; i < gift_cards.length; i++) {
                if(want == gift_cards[i]) {
                    gift_cards[i] = 0;
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    static int solution2(int[][] needs, int r) {
        int y = needs[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();
        int cnt = 0;
        int answer = 0;

        for(int i = 0; i < y; i++) {
            cnt = 0;
            for(int j = 0; j < needs.length; j++) {
                if(needs[j][i] == 1) {
                    map.put(i, ++cnt);
                }
            }
        }
        map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                                     .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1, LinkedHashMap::new));

        int idx = 0;
        for(Integer key : map.keySet()) {
            keyList.add(key);
            idx++;
            if(idx == r) {
                break;
            }
        }

        for(int i = 0; i < needs.length; i++) {
            for(int j = 0; j < y; j++) {
                if (keyList.contains(j) && needs[i][j] == 1) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
