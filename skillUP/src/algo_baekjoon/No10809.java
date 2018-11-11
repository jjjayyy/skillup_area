package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10809 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String[] alphabets = s.split("");
		
		for(char c = 'a'; c <= 'z'; c++) {
			for(int i=0; i<alphabets.length; i++) {
			
				if(alphabets[i].equals(c)) {
					System.out.print(i);
				} else {
					System.out.print(-1);
				}
				
				if(i < alphabets.length-1) {
					System.out.print(" ");
				}
			}
		}
		
	}
}
