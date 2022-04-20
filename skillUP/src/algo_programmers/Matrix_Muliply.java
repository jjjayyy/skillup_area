package algo_programmers;

public class Matrix_Muliply {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        solution(arr1, arr2);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        int tempIdx = 0;
        int temp = 0;
        while (tempIdx < arr2[0].length) {
            for(int i = 0; i < arr1.length; i++) {
                temp = 0;
                for(int j = 0; j < arr1[0].length; j++) {
                    temp += arr1[i][j] * arr2[j][tempIdx];
                }
                answer[i][tempIdx] = temp;
            }
            tempIdx++;
        }

       return answer;
    }
}
