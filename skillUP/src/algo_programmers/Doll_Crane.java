package algo_programmers;

import java.util.Stack;

public class Doll_Crane {


    public static int solution(int[][] board, int[] moves) {

        Stack<Integer> basket = new Stack<>();
        int item;
        int answer = 0;

        for(int i = 0; i < moves.length; i++) {
            for(int j = 0; j < board.length; j++) {
                item = board[j][moves[i] - 1];

                if(item == 0) {
                    continue;
                }

                if(!basket.empty() && basket.peek() == item) {
                    basket.pop();
                    board[j][moves[i] - 1] = 0;
                    answer++;
                    break;
                }
                basket.push(item);
                board[j][moves[i] - 1] = 0;
                break;
            }

        }

        return answer * 2;
    }


    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
}
