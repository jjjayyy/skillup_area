package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class No2750_MergeSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];
		
		for(int i=0; i<N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		int first = 0;
		int last = numArr.length-1;
		
		sort(numArr, first, last);
		
		IntStream stream = Arrays.stream(numArr);
		stream.forEach(System.out::println);
		
	}
	
	public static void sort(int arr[], int first, int last) {
		if(first < last) {
			
			int mid = (first + last) / 2;
			
			//배열 반씩 분할
			sort(arr, first, mid);
			sort(arr, mid+1, last);
			
			//분할한 배열 merge
			merge(arr, first, mid, last);
		}
	}
	
	public static void merge(int arr[], int first, int mid, int last) {
		int n1 = mid - first + 1;     // 처음 ~ 중간 길이
		int n2 = last - mid;		  // 중간 ~ 끝 길이
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		for(int i=0; i<n1; i++)
			L[i] = arr[first + i];
		for(int j=0; j<n2; j++)
			R[j] = arr[mid + 1 + j];
		
		//L[] R[] index 초기화
		int i = 0, j = 0;
		
		int k = first;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		
		//나머지 elements 추가
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
}
