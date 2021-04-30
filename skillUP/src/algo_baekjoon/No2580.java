package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2580 {
    static int[][] numArr = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            String[] temp = br.readLine().split(" ");

            for(int j = 0; j < temp.length; j++) {
                numArr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        dfs(0,0);
    }

    static void dfs(int row, int col) {
        if(row == 9) {
            StringBuilder builder = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    builder.append(numArr[i][j]).append(" ");
                }
                builder.append("\n");
            }
            System.out.println(builder.toString());
            System.exit(0);
            return;
        }

        if(col == 9) {
            dfs(row+1, 0);
            return;
        }

        if(numArr[row][col] == 0) {
            for(int i = 1; i <= 9; i++) {
                if(isInput(row, col, i)) {
                    numArr[row][col] = i;
                    dfs(row, col+1);
                }
            }
            numArr[row][col] = 0;
            return;
        }
        dfs(row,col+1);
    }

    static boolean isInput(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (numArr[row][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (numArr[i][col] == num) return false;
        }

        int tempRow = (row/3) * 3;
        int tempCol = (col/3) * 3;

        for(int i = tempRow; i < tempRow+3; i++) {
            for(int j = tempCol; j < tempCol+3; j++) {
                if(numArr[i][j] == num) return false;
            }
        }
        return true;
    }
}
