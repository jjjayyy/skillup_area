package algo_programmers;

public class Big_Squre {

    public static void main(String[] args) {
        int[][] board = {{0,0},{1,0}};
        solution(board);
    }

    public static int solution(int [][]board)
    {
        int answer = 0;

        if(board.length == 1 && board[0].length == 1) {
            return board[0][0] == 0 ? 0 : 1;
        }

        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[0].length; j++) {
                if(board[i][j] == 0) continue;

                int temp = Math.min(board[i-1][j-1],Math.min(board[i-1][j],board[i][j-1]));
                answer = Math.max(temp+1, answer);
                board[i][j] = temp + 1;
            }
        }
        return answer * answer;
    }
}
