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
		boolean hasAlphabet;

		for (char c = 'a'; c <= 'z'; c++) {
			hasAlphabet = false;
			
			for (int i = 0; i < alphabets.length; i++) {
				if (String.valueOf(c).equals(alphabets[i])) {
					System.out.print(i);
					hasAlphabet = true;
					break;
				} else {
					continue;
				}
			}
			
			if(!hasAlphabet) {
				System.out.print(-1);
			}
			if(c != 'z') {
				System.out.print(" ");
			}
			
		}
	}
}
