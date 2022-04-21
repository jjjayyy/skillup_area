package algo_programmers;

public class Quard_Tree_Count {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        solution(arr);
    }

    static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[2];

        getInnerSquare(arr, 0, 0, arr.length);
        return answer;
    }

    private static void getInnerSquare(int[][] arr, int rowStart, int colStart, int length) {
        if(length == 1) {
            answer[arr[rowStart][colStart]]++;
            return;
        }

        boolean isRecurrence = false;
        int temp = arr[rowStart][colStart];
        rowLoop :
        for(int i = rowStart; i < rowStart + length; i++) {
            for(int j = colStart; j < colStart + length; j++) {
                if(temp != arr[i][j]) {
                    isRecurrence = true;
                    break rowLoop;
                }
            }
        }

        if(isRecurrence) {
            getInnerSquare(arr, rowStart, colStart, length/2);
            getInnerSquare(arr, rowStart + length/2, colStart, length/2);
            getInnerSquare(arr, rowStart, colStart + length/2, length/2);
            getInnerSquare(arr, rowStart + length/2, colStart + length/2, length/2);
        } else {
            answer[temp]++;
        }

    }
}
