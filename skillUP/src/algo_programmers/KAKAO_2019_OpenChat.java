package algo_programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_2019_OpenChat {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    public static String[] solution(String[] record) {
        String[] temp = new String[2];
        StringBuilder builder = new StringBuilder();
        Map<String, String> mapById = new HashMap<>();
        List<String> recordList = new ArrayList<>();

        for(String rec : record) {
            temp = rec.split(" ");

            if(!"Leave".equals(temp[0])) {
                mapById.put(temp[1], temp[2]);
            }
        }

        for(String rec : record) {
            builder.setLength(0);
            temp = rec.split(" ");

            builder.append(mapById.get(temp[1]));

            switch (temp[0]) {
                case "Enter" : builder.append("님이 들어왔습니다."); break;
                case "Leave" : builder.append("님이 나갔습니다."); break;
            }

            if(!"Change".equals(temp[0])) {
                recordList.add(builder.toString());
            }
        }

        return recordList.stream().toArray(String[]::new);
    }
}
