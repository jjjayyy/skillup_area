package algo_baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 첫째줄 수의 개수
 * 
 * @author JH
 *
 */
public class No2750 {
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] numbers = new int[N];
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		
		int[] sortedNum = new int[N];
		
		sortedNum[0] = numbers[0];
		for(int i=0; i<N; i++) {
			if(i < N-1) {	
				if(numbers[i+1] < sortedNum[i]) {
					sortedNum[i+1] = sortedNum[i];
					sortedNum[i] = numbers[i+1];
					while(sortedNum[i] < sortedNum[i-1]) {
					}

				} else {
					sortedNum[i+1] = numbers[i+1];
				}
			} else {
				
			}
		}
		
		
		


	}
}
