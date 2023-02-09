package algo_leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatedSubstringPattern {

    public static void main(String[] args) {
//        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
//        System.out.println(isSubsequence("", "aac"));
//        int[] nums = {4,3,2,7,8,2,3,1};
//        findDisappearedNumbers(nums);

//        addStrings("1","9");
//        System.out.println(countSegments("                "));
        int[] nums = {2,1};
        thirdMax(nums);
    }

    public static int thirdMax(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        int cnt = 0;
        int result = 0;
        for(int num : list) {
            cnt++;
            if(cnt == 1 || cnt == 3) {
                result = num;
            }
        }
        System.out.println(result);
        return result;
    }

    public static int countSegments(String s) {

        String[] arr = s.split("\\s+");

        if(arr.length == 0) {
            return 0;
        }

        return arr[0].isEmpty() ? arr.length - 1 : arr.length;
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb1 = new StringBuilder(num1);
        StringBuilder sb2 = new StringBuilder(num2);

        if(num1.length() > num2.length()) {
            for(int i = 0; i < num1.length() - num2.length(); i++) {
                sb2.insert(0,"0");
            }
        } else {
            for(int i = 0; i < num2.length() - num1.length(); i++) {
                sb1.insert(0,"0");
            }
        }

        int temp = 0;
        StringBuilder sumSb = new StringBuilder();
        for(int i = sb1.length()-1; i >= 0; i--) {
            int sum = Integer.parseInt(sb1.charAt(i) + "") + Integer.parseInt(sb2.charAt(i) + "") + temp;
            temp = sum / 10;
            sumSb.insert(0, String.valueOf(sum % 10));
        }

        if(temp > 0) sumSb.insert(0, String.valueOf(temp));

        System.out.println(sumSb.toString());
        return sumSb.toString();
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] isAppearedArr = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            isAppearedArr[nums[i]-1] = true;
        }

        for(int i = 0; i < isAppearedArr.length; i++) {
            if(!isAppearedArr[i]) {
                list.add(i+1);
            }
        }

        return list;
    }
    public static boolean isSubsequence(String s, String t) {

        int tIndex = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = tIndex; j < t.length(); j++) {
                tIndex++;
                if(t.charAt(j) == s.charAt(i)) {
                    break;
                }
            }

            if(tIndex == t.length()) {
                return i == s.length()-1 && s.charAt(i) == t.charAt(tIndex-1);
            }
        }
        return true;
    }

    public static boolean repeatedSubstringPattern(String s) {

        for(int i = s.length()/2; i > 0; i--) {
            if(s.length() % i != 0) {
                continue;
            }

            int repeatCnt = s.length() / i;
            String pattern = s.substring(0, i);
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < repeatCnt; j++) {
                sb.append(pattern);
            }

            if(s.equals(sb.toString())) {
                return true;
            }
        }

        return false;
    }
}
