package algo_programmers;

public class Remove_By_Pair {

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s)
    {

        if(s.length() % 2 != 0) {
            return 0;
        }

        StringBuilder tempBuilder = new StringBuilder();
        StringBuilder builder = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++) {
            if(tempBuilder.length() > 0 && tempBuilder.charAt(tempBuilder.length()-1) == s.charAt(i)) {
                tempBuilder.deleteCharAt(tempBuilder.length()-1);
                continue;
            }

            tempBuilder.append(s.charAt(i));
            if(s.length() - i < tempBuilder.length()) {
                return 0;
            }
        }

        return 1;

//        int index = 0;
//
//        while(builder.length() > 0) {
//            if(index > 0 && builder.charAt(index-1) == builder.charAt(index)) {
//                builder.delete(index-1, index+1);
//                index = 0;
//                continue;
//            }
//            index++;
//
//            if(index == builder.length()) {
//                break;
//            }
//        }

//        System.out.println(builder.length());
//        return builder.length() > 0 ? 0 : 1;
    }
}
