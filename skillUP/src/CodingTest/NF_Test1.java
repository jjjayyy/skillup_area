package CodingTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NF_Test1 {
    public static void main(String[] args) {
        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
        int k = 2;
        solution(id_list, 3);
    }

    public static int solution(String[] id_list, int k) {
        List<String> id_buy_oneday_chk_list = new ArrayList<>();
        Map<String, Integer> id_cnt_map = new HashMap<>();
        int answer = 0;

        for(String id_by_day : id_list) {
            String[] id_arr = id_by_day.split(" ");
            id_buy_oneday_chk_list.clear();

            for(String id : id_arr) {
                if(id_buy_oneday_chk_list.contains(id) || (id_cnt_map.containsKey(id) && id_cnt_map.get(id) == k)) {
                    continue;
                }
                id_cnt_map.put(id, id_cnt_map.getOrDefault(id,0) + 1);
                id_buy_oneday_chk_list.add(id);
                answer++;
            }
        }
        return answer;
    }
}
