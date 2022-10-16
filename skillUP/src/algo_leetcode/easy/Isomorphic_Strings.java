package algo_leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic_Strings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> tempMap = new HashMap();
        Map<Character, Character> reverseTempMap = new HashMap();

        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if((tempMap.containsKey(charS) && tempMap.get(charS) != charT) || (reverseTempMap.containsKey(charT) && reverseTempMap.get(charT) != charS)) {
                return false;
            }

            tempMap.put(charS, charT);
            reverseTempMap.put(charT, charS);
        }
        return true;
    }
}
