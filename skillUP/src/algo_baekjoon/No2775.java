package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			
			int people = 0;
			
			for(int m = 0; m <= k-1; m++) {
				for(int j = 1; j <= n; j++) {
					people += j;
					
				}
			}
			System.out.println(people);
		}
	}
}
