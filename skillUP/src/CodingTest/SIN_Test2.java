package CodingTest;

import java.util.*;

public class SIN_Test2 {

    public static Scanner scanner = new Scanner(System.in);
    public static Map<Integer,Integer> resultMap;

    public static void main(String[] args) {
        String[] nmArr = scanner.nextLine().split(" ");
        int N = Integer.parseInt(nmArr[0]);
        int M = Integer.parseInt(nmArr[1]);

        resultMap = new HashMap<>();
        List<Map<String, Integer>> buttonList = getBtnList(N);

        for(int i = 0; i < M; i++) {
            String[] tempArr = scanner.nextLine().split(" ");
            int x = Integer.parseInt(tempArr[0]);
            int y = Integer.parseInt(tempArr[1]);

            for(int j = buttonList.size()-1; j >= 0; j--) {
                int x1 = buttonList.get(j).get("x1");
                int x2 = buttonList.get(j).get("x2");
                int y1 = buttonList.get(j).get("y1");
                int y2 = buttonList.get(j).get("y2");

                if(x >= x1 && x <= x2 && y >= y1 && y <= y2) {
                    resultMap.put(j+1,resultMap.getOrDefault(j+1, 0) + 1);     // 클릭된 버튼만 나와도 상관없을 경우 getOrDefault
                    break;
                }
            }
        }

        for(int key : resultMap.keySet()) {
            System.out.println("Button #" + key + ": " + resultMap.get(key));
        }
    }

    private static List<Map<String, Integer>> getBtnList(int N) {
        List<Map<String, Integer>> buttonList = new ArrayList<>();
        Map<String, Integer> buttonMap;
        for(int i = 0; i < N; i++) {
            String[] tempArr = scanner.nextLine().split(" ");

            buttonMap = new HashMap<>();
            buttonMap.put("x1", Integer.parseInt(tempArr[0]));
            buttonMap.put("x2", Integer.parseInt(tempArr[1]));
            buttonMap.put("y1", Integer.parseInt(tempArr[2]));
            buttonMap.put("y2", Integer.parseInt(tempArr[3]));

            buttonList.add(buttonMap);
            resultMap.put(i+1, 0);
        }
        return buttonList;
    }


}
