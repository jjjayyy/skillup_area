package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1157 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String upperWord = br.readLine().toUpperCase();

		String[] alphabets = new String[upperWord.length()];
		
		alphabets = upperWord.split("");
		int cnt = 0;
		
		for(int i = 0; i < alphabets.length; i++) {
			for(int j = 0; j < alphabets.length; j++) {
				if(alphabets[i].equals(alphabets[j])) {
					cnt++;
				}
			}
		}
	}
}
