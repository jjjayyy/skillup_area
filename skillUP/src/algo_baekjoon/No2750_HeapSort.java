package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class No2750_HeapSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		sort(numArr, N);
		
		IntStream stream = Arrays.stream(numArr);
		stream.forEach(System.out::println);
		
	}
	
	public static void sort(int numArr[], int N) {
		
		// Build heap
		for(int i = N / 2 - 1; i >= 0; i--){
			heapify(numArr, N, i);
		}
		
		for(int i = N-1; i >= 0; i--) {
			//heapify 하면 [0]에 가장 큰 수가 옴 (힙 구조 참고)
			int temp = numArr[0];
			numArr[0] = numArr[i];
			numArr[i] = temp;
			
			//heap 다시 빌드해서 가장 큰 수 찾음
			heapify(numArr, i, 0);
		}
	}
	
	public static void heapify(int numArr[], int N, int i) {
		
		int largest = i;
		int left = 2*i + 1;
		int right = 2*i + 2;
		
		if(left < N && numArr[left] > numArr[largest]) {
			largest = left;
		}
		
		if(right < N && numArr[right] > numArr[largest]) {
			largest = right;
		}
		
		if(largest != i) {
			int swap = numArr[i];
			numArr[i] = numArr[largest];
			numArr[largest] = swap;
			
			heapify(numArr, N, largest);
		}
	}
}
