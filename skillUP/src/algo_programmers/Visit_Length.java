package algo_programmers;

import java.util.HashMap;
import java.util.Map;

public class Visit_Length {
    public static void main(String[] args) {
//        String dirs = "UDLRU";
        String dirs = "ULURRDLLU";
        solution(dirs);

    }

    public static int solution(String dirs) {
        int answer = 0;

        Map<String, Boolean> visitedMap = new HashMap<>();
        Map<String, Boolean> reVisitedMap = new HashMap<>();
        int[] temp = {0,0};

        for(int i = 0; i < dirs.length(); i++) {
            int[] start = temp.clone();
            int[] end = goToNext(start, dirs.charAt(i));

            if(Math.abs(end[0]) > 5 || Math.abs(end[1]) > 5) continue;

            String startEnd = start[0] + "" + start[1] + "" + end[0] + "" + end[1];
            String endStart = end[0] + "" + end[1] + "" + start[0] + "" + start[1];

            if(visitedMap.containsKey(startEnd) && visitedMap.get(startEnd)
            || reVisitedMap.containsKey(startEnd) && reVisitedMap.get(startEnd)) {

            } else {
                answer++;
                visitedMap.put(startEnd,true);
                reVisitedMap.put(endStart,true);
            }

            temp = end.clone();
        }
        System.out.println(answer);
        return answer;
    }

    private static int[] goToNext(int[] curr, char dir) {
        int[] next = curr.clone();
        switch(dir) {
            case 'U' : next[1]++; break;
            case 'D' : next[1]--; break;
            case 'R' : next[0]++; break;
            case 'L' : next[0]--; break;
        }
        return next;
    }
}
