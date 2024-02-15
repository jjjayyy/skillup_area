public class main_leet_medium {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.println(matrix);
    }

    public static void rotate(int[][] matrix) {

//        0,0 = 0,2 /;
//        0,1 = 1,2 /;
//        0,2 = 2,2;
//
//        1,0 = 0,1 /;
//        1,1 = 1,1 /;
//        1,2 = 2,1;
//
//        2,0 = 0,0 /;
//        2,1 = 1,0 /;
//        2,2 = 2,0

        int n = matrix.length;
        int[][] resultMatrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            int x = i-i;
            int y = n-1-i;
            for(int j = 0; j < n; j++) {
                resultMatrix[x][y] = matrix[i][j];
                x++;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = resultMatrix[i][j];
            }
        }
    }
}
