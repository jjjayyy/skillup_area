package algo_programmers;

public class Jump_Teleport {
    public static void main(String[] args) {
        solution(5000);
    }

    public static int solution(int n) {
        int ans = 1;

        while(n > 1) {
            //if(n % 2 == 0) break;
            ans += n % 2;
            n /= 2;
        }
        System.out.println(ans);
        return ans;
    }
}
