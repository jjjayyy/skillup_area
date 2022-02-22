package algo_leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Roman_To_Integer {
    public static void main(String[] args) {
        romanToInt("MCMXCIV");
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = createRomanMap();
        int sum = 0;

        for(int i = 0; i < s.length()-1; i++) {
            int nextNum = romanMap.get(s.charAt(i+1));
            int thisNum = romanMap.get(s.charAt(i));

            if(nextNum > thisNum) {
                sum -= thisNum;
            } else {
                sum += thisNum;
            }
        }
        System.out.println(sum);
        return sum + romanMap.get(s.charAt(s.length()-1));
    }

    private static Map<Character, Integer> createRomanMap() {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        return romanMap;
    }
}
