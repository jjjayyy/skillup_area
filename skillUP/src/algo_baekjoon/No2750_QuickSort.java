package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class No2750_QuickSort {
	public static void main(String[] args) throws IOException {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
	
		findSorting(numArr, 0, N-1);
		
		IntStream stream = Arrays.stream(numArr);
		stream.forEach(System.out::println);
	}
	
	public static void findSorting(int numArr[], int left, int right) {
		if(left < right) {
			int p = sort(numArr, left, right);
			findSorting(numArr, left, p-1);
			findSorting(numArr, p+1, right);
		}
	}
	
	public static int sort(int numArr[], int left, int right) {
		
		int pivot = (left + right) / 2;			//랜덤 값 pivot에 대입
		
		//left 탐색
		while(left < right && numArr[pivot] > numArr[left]) {
			left++;
		}
		
		//right 탐색
		while(left < right && numArr[pivot] <= numArr[right]) {
			right--;
		}
		
		//arr[left] > arr[pivot] && arr[right] < arr[pivot] && left != right
		if(left < right && numArr[left] > numArr[right]) {
			swap(numArr, left, right);
			if(left == pivot) {			//pivot이 옮겨질 경우, 처음부터 재탐색
				sort(numArr, 0, numArr.length-1);
			} else {
				sort(numArr, left, right);
			}
		}
		
		if(left == right) {
			swap(numArr, left, pivot);
		}
		return left;
	}
	
	public static void swap(int numArr[], int a, int b) {
		int swap = numArr[a];
		numArr[a] = numArr[b];
		numArr[b] = swap;
	}
}
