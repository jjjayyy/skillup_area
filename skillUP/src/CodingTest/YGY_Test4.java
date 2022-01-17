package CodingTest;

public class YGY_Test4 {

    public static void main(String[] args) {
        int[] A = {3,1,2};
        int[] B = {2,3,1};
//        System.out.println(solution(A,B));


    }

    public static boolean solution(int[] A, int[] B) {

        boolean[][] visited = new boolean[100000][100000];
        for(int i = 0; i < A.length; i++) {
            if(A[i] == B[i]) {
                return false;
            }

            if(visited[B[i]][A[i]]) {
                return false;
            }
            visited[A[i]][B[i]] = true;

        }

        return true;
    }
}
