package algo_programmers;


import java.util.*;
import java.util.stream.Collectors;

public class KAKAO_2022_ReceiveResult {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        solution(id_list, report, 2);
    }

    private static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportMap = new HashMap<>();
        Map<String, List<String>> idToList = new HashMap<>();

        List<String> reportList = Arrays.stream(report).distinct().collect(Collectors.toList());

        for(String rep : reportList) {
            String from = rep.split(" ")[0];
            String to = rep.split(" ")[1];

            List<String> tempList = idToList.containsKey(from) ? idToList.get(from) : new ArrayList<>();

            tempList.add(to);
            reportMap.put(to, reportMap.getOrDefault(to, 0)+1);
            idToList.put(from, tempList);
        }

        reportMap = reportMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= k)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        int index = 0;
        for(String id : id_list) {
            int cnt = 0;
            for(String key : reportMap.keySet()) {
                if(idToList.containsKey(id) && idToList.get(id).contains(key)) {
                    cnt++;
                }
            }
            answer[index] = cnt;
                    index++;
        }

        for(int i : answer) {
            System.out.println(i);
        }
        return answer;
    }
}
