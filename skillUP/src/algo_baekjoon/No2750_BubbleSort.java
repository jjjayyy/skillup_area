package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 첫째줄 수의 개수
 * Bubble Sort
 * 
 * @author JH
 *
 */
public class No2750_BubbleSort {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];

		IntStream stream = Arrays.stream(numArr);

		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}

		for(int i=0; i<N; i++) {
			int index = N-1;
				while(index > i) {
					if(index > 0 && numArr[index-1] > numArr[index]) {
						int temp = numArr[index];
						numArr[index] = numArr[index-1];
						numArr[index-1] = temp;
					}
						index--;
				}
		}
		stream.forEach(System.out::println);
	}
}
