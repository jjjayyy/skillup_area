package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No1018 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int M = Integer.parseInt(temp[0]);
        int N = Integer.parseInt(temp[1]);

        String[] rows = new String[M];

        for(int i = 0; i < M; i++) {
            rows[i] = br.readLine();
        }

        int colLength = N - 8;
        int rowLength = M - 8;
        int result = Integer.MAX_VALUE;

        for(int i = 0; i <= rowLength; i++) {
            for(int j = 0; j <= colLength; j++) {
                result = Math.min(result, getCnt(rows, i, j));
            }
        }
        System.out.println(result);
    }

    static int getCnt(String[] rows, int row, int col) {
        int cnt = 0;
        char tempColor = rows[row].charAt(col);

        for(int i = row; i < row+8; i++) {
            for(int j = col; j < col+8; j++) {
                if(j > col) {
                    tempColor = tempColor == 'B' ? 'W' : 'B';
                }

                if(tempColor != rows[i].charAt(j)) {
                    cnt++;
                }
            }
        }
        return Math.min(cnt, 64-cnt);
    }
}
