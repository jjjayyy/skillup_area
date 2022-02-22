package algo_leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Excel_Sheet_Cloumn_Number {

    public static void main(String[] args) {
        titleToNumber("AAA");
    }

    public static int titleToNumber(String columnTitle) {
        Map<Character, Integer> colMap = createColMap();
        int sum = 0;

        for(int i = 0; i < columnTitle.length(); i++) {
            int index = columnTitle.length()-i-1;
            int num = colMap.get(columnTitle.charAt(i));
            sum += index > 0 ? Math.pow(colMap.size(), index) * num : num;
        }
        System.out.println(sum);
        return sum;
    }

    private static Map<Character, Integer> createColMap() {
        Map<Character, Integer> colMap = new HashMap<>();
        int idx = 1;
        for(char c = 'A'; c <= 'Z'; c++) {
            colMap.put(c,idx);
            idx++;
        }
        return colMap;
    }

}
