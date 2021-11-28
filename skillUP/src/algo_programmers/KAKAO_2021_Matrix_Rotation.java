package algo_programmers;

public class KAKAO_2021_Matrix_Rotation {

    static private int matrix[][];

    public static void main(String[] args) {
        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        solution(6,6, queries);
    }

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        matrix = new int[rows][columns];

        int num = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = num++;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    private static int rotate(int[] query) {
        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;

        int min = Integer.MAX_VALUE;
        int temp = matrix[r1][c1];
        for(int i = r1; i < r2; i++) {
            matrix[i][c1] = matrix[i+1][c1];
            min = Math.min(min, matrix[i][c1]);
        }

        for(int i = c1; i < c2; i++) {
            matrix[r2][i] = matrix[r2][i+1];
            min = Math.min(min, matrix[r2][i]);
        }

        for(int i = r2; i > r1; i--) {
            matrix[i][c2] = matrix[i-1][c2];
            min = Math.min(min, matrix[i][c2]);
        }

        for(int i = c2; i > c1; i--) {
            matrix[r1][i] = matrix[r1][i-1];
            min = Math.min(min, matrix[r1][i]);
        }
        matrix[r1][c1+1] = temp;

        return min;
    }
}
