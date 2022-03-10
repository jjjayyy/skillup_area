package algo_hackerrank.medium;

public class Minimum_Swap2 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};
        minimumSwaps(arr);
    }

    static int minimumSwaps(int[] arr) {

        int cnt = 0;
        boolean isNotSorted = true;
        int temp = 0;
        while(isNotSorted) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != i + 1) {

                    temp = arr[i];
                    arr[i] = arr[temp-1];
                    arr[temp-1] = temp;
                    cnt++;
                    break;
                }
                if(i == arr.length-1) isNotSorted = false;
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}
