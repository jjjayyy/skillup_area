package CodingTest;

import java.util.*;

public class MSS_Test2 {
    public static void main(String[] args) {
//        String[][] friends = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
//        String user_id = "david";

        String[][] friends = {{"david","demi"}, {"frank", "demi"}, {"demi", "james"}};
        String user_id = "frank";
        solution(friends, user_id);
    }

    public static String[] solution(String[][] friends, String user_id) {
        Map<String, List<String>> relationMap = getRelationMap(friends, user_id);

        List<String> targetList = relationMap.get(user_id);
        Map<String, Integer> cntMap = new HashMap<>();
        int maxRelation = 0;
        for(String key : relationMap.keySet()) {
            if(key.equals(user_id) || targetList.contains(key)) continue;

            relationMap.get(key).retainAll(targetList);
            maxRelation = Math.max(maxRelation, relationMap.get(key).size());
            cntMap.put(key, relationMap.get(key).size());
        }

        List<String> resultList = new ArrayList<>();
        for(String key : cntMap.keySet()) {
            if(maxRelation == cntMap.get(key)) {
                resultList.add(key);
            }
        }

        return resultList.stream()
                .sorted()
                .toArray(String[]::new);
    }

    private static Map<String, List<String>> getRelationMap(String[][] friends, String user_id) {
        Map<String, List<String>> relationMap = new HashMap<>();
        List<String> tempList;
        for(String[] friend : friends) {
            tempList = relationMap.computeIfAbsent(friend[0], t -> new ArrayList<String>());
            tempList.add(friend[1]);
            tempList = relationMap.computeIfAbsent(friend[1], t -> new ArrayList<String>());
            tempList.add(friend[0]);
        }

        return relationMap;
    }
}
