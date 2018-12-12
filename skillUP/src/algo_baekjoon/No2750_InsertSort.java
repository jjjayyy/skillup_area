package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class No2750_InsertSort {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<N; i++) {

			int standard = numArr[i];
			int index = i;
		
			if(i > 0) {
				while(standard < numArr[index-1]) {

					int temp = numArr[index];
					numArr[index] = numArr[index-1];
					numArr[index-1] = temp;
					
					if(index > 1) {
						index--;
					}
				}
			}
		}
		IntStream stream = Arrays.stream(numArr);
		stream.forEach(System.out::println);

	}
}
