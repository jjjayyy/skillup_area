package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int first = 0;
		int second = 0;
		int result = N;
		int cycle = 0;
		
		while(cycle == 0 || result != N) {
			first = (result < 10) ? 0 : result / 10;
			second = result % 10;
			
			int temp = first + second;
			first = second;
			second = temp % 10;
			result = first * 10 + second;
			cycle++;
		}
		System.out.println(cycle);
	}
}
