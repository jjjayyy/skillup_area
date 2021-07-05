package algo_programmers;

public class Make_Sosu {

    static boolean[] visited;
    static int[] numbers;
    static int answer = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};
        solution(nums2);
    }

    public static int solution(int[] nums) {
        visited = new boolean[nums.length];
        numbers = nums;

        dfs(0, 0, 0);
        System.out.println(answer);
        return answer;
    }

    public static void dfs(int sum, int depth, int idx) {
        if(depth == 3) {
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }

        for(int i = idx; i < numbers.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(sum + numbers[i], depth + 1, i+1);
                visited[i] = false;
            }

        }

    }
    public static boolean isPrime(int num) {
        boolean isPrime = true;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}
