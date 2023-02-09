package algo_leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Reverse_Vowels_of_a_String {

    public static boolean canConstruct(String ransomNote, String magazine) {
         StringBuilder sb = new StringBuilder(magazine);
         for(int i = 0; i < ransomNote.length(); i++) {
             if(!sb.toString().contains(ransomNote.charAt(i) + "") || sb.length() == 0) {
                 return false;
             }
            sb.deleteCharAt(sb.indexOf(ransomNote.charAt(i) + ""));

         }
        return true;
    }


    public static void main(String[] args) {
//        System.out.println(reverseVowels("aA"));

//        int[] nums1 = {2,2,3};
//        int[] nums2 = {2,1};
//        Arrays.stream(intersection(nums1, nums2)).forEach(System.out::println);


        canConstruct("aa","ab");
    }

    public static String reverseVowels(String s) {
        String[] vowels = {"a","e","i","o","u","A","E","I","O","U"};
        List<String> list = Arrays.asList(vowels);
        Queue<String> q = new LinkedList<>();

        for(int i = s.length()-1; i >= 0; i--) {
            String temp = s.charAt(i)+"";
            if(list.contains(temp)) {
                q.add(temp);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(list.contains(s.charAt(i)+"")) {
                stringBuilder.append(q.poll());
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1)
                .filter(num -> Arrays.stream(nums2).anyMatch(num2 -> num == num2))
                .distinct()
                .toArray();
    }

}
