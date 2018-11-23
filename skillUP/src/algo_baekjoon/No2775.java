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
			
			int[] people = new int[n];
			int cnt = 0;
			int resident = 0;
			
			while(cnt < k) {	
				for(int j = 0; j < n; j++) {					
					if(cnt == 0) {
						people[j] = j + 1;
					} else {
						if(j != 0) {people[j] += people[j-1];}
					}
				}
			cnt++;
			}
			
			for(int m = 0; m < n; m++) {
				resident += people[m];
			}
			System.out.println(resident);
		}
	}
}
