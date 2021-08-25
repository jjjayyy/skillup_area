package algo_programmers;

import java.util.*;
import java.util.stream.Collectors;

public class KAKAO_2021_Menu_Renewal {

    private static boolean[] visited = new boolean[11];
    private static StringBuilder builder = new StringBuilder();
    private static Map<String,Integer> map = new HashMap<>();
    static List<Integer> courseList = new ArrayList<>();
    static Map<Integer, Integer> cntMap = new HashMap<>();

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] answer = solution(orders, course);
        for(String ans : answer) {
            System.out.println(ans);
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        courseList = Arrays.stream(course).boxed().collect(Collectors.toList());
        List<String> answerList = new ArrayList<>();

        for(String order : orders) {
            char[] charArr = order.toCharArray();
            Arrays.sort(charArr);
            String orderBySorted = new String(charArr);
            dfs(0, orderBySorted);
        }

        for(String key : map.keySet()) {
            if(map.get(key) > 1) {
                if(cntMap.get(key.length()) == map.get(key)) {
                    answerList.add(key);
                }
            }
        }
        return answerList.stream().sorted().toArray(String[]::new);
    }

    private static void dfs(int index, String order) {
        if(index > order.length()) {
            builder.setLength(0);
            return;
        }

        if(courseList.contains(builder.length())) {
            String temp = builder.toString();
            int cnt = map.getOrDefault(temp, 0) + 1;
            map.put(temp, cnt);
            cntMap.put(builder.length(),Math.max(cntMap.getOrDefault(builder.length(),0), cnt));
        }

        for(int i = index; i < order.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                builder.append(order.charAt(i));
                dfs(i+1, order);
                builder.deleteCharAt(builder.length()-1);
                visited[i] = false;

            }
        }
    }
}
