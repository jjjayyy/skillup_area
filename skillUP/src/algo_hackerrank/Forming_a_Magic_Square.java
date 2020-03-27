package algo_hackerrank;

public class Forming_a_Magic_Square {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {

        int[][] magicSqure1 = {{8,1,6}, {3,5,7}, {4,9,2}};
        int[][] magicSqure2 = {{6,1,8}, {7,5,3}, {2,9,4}};
        int[][] magicSqure3 = {{4,9,2}, {3,5,7}, {8,1,6}};
        int[][] magicSqure4 = {{2,9,4}, {7,5,3}, {6,1,8}};
        int[][] magicSqure5 = {{8,3,4}, {1,5,9}, {6,7,2}};
        int[][] magicSqure6 = {{4,3,8}, {9,5,1}, {2,7,6}};
        int[][] magicSqure7 = {{6,7,2}, {1,5,9}, {8,3,4}};
        int[][] magicSqure8 = {{2,7,6}, {9,5,1}, {4,3,8}};

        int[] sum = new int[8];

        for(int i = 0; i < s.length; i++) {
            for(int j = 0; j < s[0].length; j++) {

                sum[0] += Math.abs(s[i][j] - magicSqure1[i][j]);
                sum[1] += Math.abs(s[i][j] - magicSqure2[i][j]);
                sum[2] += Math.abs(s[i][j] - magicSqure3[i][j]);
                sum[3] += Math.abs(s[i][j] - magicSqure4[i][j]);
                sum[4] += Math.abs(s[i][j] - magicSqure5[i][j]);
                sum[5] += Math.abs(s[i][j] - magicSqure6[i][j]);
                sum[6] += Math.abs(s[i][j] - magicSqure7[i][j]);
                sum[7] += Math.abs(s[i][j] - magicSqure8[i][j]);

            }
        }

        int min = sum[0];

        for(int val : sum) {
            if(min > val) {
                min = val;
            }
        }
        return min;
    }


    public static void main(String[] args) {

    }
}
