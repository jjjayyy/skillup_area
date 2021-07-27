package algo_programmers;

public class Yaksu_Count_Plus {
    public static void main(String[] args) {
        solution(13, 17);
    }

    static public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i <= right; i++) {
            int cnt = 1;
            for(int j = 1; j <= i/2; j++) {
                if(i % j == 0) {
                    cnt++;
                }
            }
            int sign = cnt % 2 == 0 ? 1 : -1;
            answer += i * sign;
        }
        return answer;
    }
}
