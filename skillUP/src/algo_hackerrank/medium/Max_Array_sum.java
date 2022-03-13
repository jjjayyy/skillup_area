package algo_hackerrank.medium;

public class Max_Array_sum {
    public static void main(String[] args) {
//        int[] arr = {3, 7, 4, 6, 5};
        int[] arr = {3, 5, -7, 8, 10};
        System.out.println(maxSubsetSum(arr));
    }

    static int maxSubsetSum(int[] arr) {
        int[] tempArr = new int[arr.length+1];
        tempArr[0] = Integer.MIN_VALUE;
        tempArr[1] = Math.max(0, arr[0]);
        tempArr[2] = Math.max(arr[0], arr[1]);

        if(arr.length == 0) return 0;
        if(arr.length == 1) return Math.max(arr[0], arr[1]);
        int max = 0;

        for(int i = 2; i < arr.length; i++) {
            int maxNum = Math.max(tempArr[i-1], tempArr[i-2]);
            tempArr[i+1] = arr[i] >= 0 ? Math.max(maxNum + arr[i], arr[i]) : maxNum;
            max = Math.max(max, tempArr[i+1]);
        }

        return max;
    }

}
