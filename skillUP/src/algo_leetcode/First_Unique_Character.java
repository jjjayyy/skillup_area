package algo_leetcode;

public class First_Unique_Character {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static int firstUniqChar(String s) {
        int[] alphabets = new int[26];
        for(int i=0; i< s.length(); ++i){
            alphabets[s.charAt(i)-97]++;
        }

        for(int i=0; i < s.length(); ++i){
            if(alphabets[s.charAt(i)-97] == 1){
                return i;
            }
        }
        return -1;

//        int result = -1;
//
//        for(int i = 0; i < s.length(); i++) {
//            StringBuilder sb = new StringBuilder(s);
//            if(!sb.deleteCharAt(i).toString().contains(String.valueOf(s.charAt(i)))) {
//                result = i;
//                break;
//            }
//        }
//
//        System.out.println(result);
//        return result;
    }
}
