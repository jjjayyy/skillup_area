package algo_programmers;

public class Correct_Bracket {
    public static void main(String[] args) {
        System.out.println(solution("()((("));
    }

    static boolean solution(String s) {
        int answer = 0;
        for(char c : s.toCharArray()) {
            answer = c == '(' ? answer + 1 : answer - 1;
            if(answer < 0) {
                return false;
            }
        }
        return answer == 0;
    }
}
