package algo_baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No7568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][2];
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");

            people[i][0] = Integer.parseInt(temp[0]);
            people[i][1] = Integer.parseInt(temp[1]);
        }

        for(int i = 0; i < people.length; i++) {
            int rank = 1;
            for(int j = 0; j < people.length; j++) {
                if(people[i][0] < people[j][0] && people[i][1] < people[j][1]){
                    rank++;
                }
            }
            builder.append(rank);
            if(i != people.length - 1) {
                builder.append(" ");
            }
        }
        System.out.println(builder.toString());
    }
}
