package algo_programmers;

public class Immigration {
    public static void main(String[] args) {
        int[] times = {6, 8, 10};
        System.out.println(solution(10, times));
    }

    public static long solution(int n, int[] times) {
        long start = 0;
        long end = 0;
        long ans = 0;

        for(long time : times) {
            end = Math.max(time*n, end);
        }

        while(start <= end) {
            long temp = 0;
            long mid = (end + start) / 2;

            for(int time : times) {
                temp += mid / time;
            }

            if(temp < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
