package algo_leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

public class Longest_Common_Prefix {
    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"a", "b"};

        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder();
        String strByMinLength = Arrays.stream(strs)
                .min(Comparator.comparing(str -> str.length()))
                .orElse("");
        boolean isSamePrefix = true;

        for(int i = 0; i < strByMinLength.length(); i++) {
            sb.append(strByMinLength.charAt(i));
            for(int j = 0; j < strs.length; j++) {
                if(sb.length() > 0 && !strs[j].startsWith(sb.toString())) {
                    isSamePrefix = false;
                    break;
                }
            }
            if(!isSamePrefix) {
                sb.deleteCharAt(sb.length()-1);
                break;
            }
        }

        return sb.toString();
    }
}
