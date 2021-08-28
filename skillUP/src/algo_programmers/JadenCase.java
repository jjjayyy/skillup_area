package algo_programmers;

public class JadenCase {

    public static void main(String[] args) {
        System.out.println(solution("for the last week a"));
    }

    public static String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);

        boolean isFirst = true;

        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == ' ') {
                isFirst = true;
                continue;
            }

            if(!isFirst) continue;

            if(!isNumber(String.valueOf(sb.charAt(i)))) {
                String temp = String.valueOf(sb.charAt(i));
                sb.replace(i, i+1, temp.toUpperCase());
            }

            isFirst = false;
        }
        return sb.toString();
    }

    private static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
