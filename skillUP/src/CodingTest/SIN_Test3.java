package CodingTest;

import java.util.*;
import java.util.stream.Collectors;

public class SIN_Test3 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        String[] nmArr = scanner.nextLine().split(" ");
        int N = Integer.parseInt(nmArr[0]);
        int M = Integer.parseInt(nmArr[1]);

        String[] nameArr = scanner.nextLine().split(" ");
        Map<String, List<String>> relationMap = new HashMap<>();
        for(String name : nameArr) {
            relationMap.put(name, new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            String[] temp = scanner.nextLine().split(" ");

            List<String> tempList = relationMap.get(temp[0]);
            tempList.add(temp[1]);
            tempList = relationMap.get(temp[1]);
            tempList.add(temp[0]);
        }

        Map<String, Integer> resultMap = new HashMap<>();
        for(String key : relationMap.keySet()) {
            for(String innerKey : relationMap.keySet()) {
                if(key.equals(innerKey)) break;

                int cnt = (int) relationMap.get(key).stream().filter(v -> relationMap.get(innerKey).contains(v)).count();

                String resultKey = key + " " + innerKey;
                resultMap.put(resultKey, cnt);
            }
        }

        String resultKey = Collections.max(resultMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        int resultValue = resultMap.get(resultKey);

        String[] temp = resultKey.split(" ");
        Arrays.sort(temp);

        String ans = "";

        for(String t : temp) {
            ans += t + " ";
        }

        System.out.println(ans.trim());
        System.out.println(resultValue);

    }
}
