package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2675 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] st = new String[T];
		
		for(int i=0; i<T; i++) {
			st[i] = br.readLine();
			int repeatCnt = st[i].charAt(0) - '0';
			int stCnt = st[i].length();
			
			for(int j=2; j<stCnt; j++) {
				for(int k=0; k<repeatCnt; k++) {
					System.out.print(st[i].charAt(j));
				}
			}
			System.out.println();
		}
	}
}
