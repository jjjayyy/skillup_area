package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2675 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] st = new String[T];
		
		for(int i=0; i<T; i++) {
			st[i] = br.readLine();
		}
		
		for(int j=0; j<st.length; j++) {
			String[] stSplit = st[j].split(" ");
			int R = Integer.parseInt(stSplit[0]);
			String S = stSplit[1];
			
			String[] sChars = S.split("");
			
			for(int k=0; k<sChars.length; k++) {
				int l = 1;
				while(l <= R) {
					System.out.print(sChars[k]);
					l++;
				}
			}
		}
		
	}
}
