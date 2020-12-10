package algo_programmers;

public class Changing_Bracket {

    public static String solution(String p) {
        if("".equals(p)) {
            return "";
        }

        String u = "";
        String v = "";
        StringBuilder builder = new StringBuilder();

        char startBracket = p.charAt(0);
        int bracketCnt = 0;

        for(int i = 0; i < p.length(); i++) {
            bracketCnt = startBracket == p.charAt(i) ? bracketCnt + 1 : bracketCnt - 1;

            if(bracketCnt == 0) {
                u = p.substring(0, i+1);
                v = p.substring(i+1, p.length());
                break;
            }
        }

        if(isCorrect(u)) {
            builder.append(u);
            builder.append(solution(v));
        } else {
            builder.append("(");
            builder.append(solution(v));
            builder.append(")");

            String tempStr = u.substring(1,u.length()-1);
            tempStr = reverse(tempStr);

            builder.append(tempStr);
        }

        return  builder.toString();
    }

    private static boolean isCorrect (String str) {
        int bracketCnt = 0;

        for(int i = 0; i < str.length(); i++) {
            bracketCnt = str.charAt(i) == '(' ? bracketCnt + 1 : bracketCnt - 1;

            if(bracketCnt < 0) 	return false;

        }
        return true;
    }

    private static String reverse (String str) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ')') {
                builder.append('(');
            } else {
                builder.append(')');
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution(")("));
    }


}
