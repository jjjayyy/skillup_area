package algo_hackerrank.easy;

public class Counting_Valleys {
    public static void main(String[] args) {
        countingValleys(12, "DDUUDDUDUUUD");
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here

        int step = 0;
        int cnt = 0;
        boolean isValley = false;

        for(int i = 0; i < path.length(); i++) {
            step = path.charAt(i) == 'U' ? step + 1 : step - 1;

            if(step < 0 && !isValley) {
                isValley = true;
            }

            if(step >= 0 && isValley) {
                isValley = false;
                cnt++;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
