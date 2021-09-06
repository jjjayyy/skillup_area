package algo_programmers;

public class Weekly_5week {

    public static void main(String[] args) {
        solution("I");
    }

    public static int solution(String word) {
        int answer = 0;
        int[] cntArr = {781, 156, 31, 6, 1};
        String strByCnt = "AEIOU";

        for(int i = 0; i < word.length(); i++) {
            answer += cntArr[i] * strByCnt.indexOf(word.charAt(i)) + 1;
        }
        System.out.println(answer);
        return answer;
    }
}
