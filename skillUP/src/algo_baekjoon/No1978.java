package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = br.readLine().split("\\s");
		int sosuCnt = 0;
		
		for(int i = 0; i < N; i++) {
			if(isSosu(Integer.parseInt(strArr[i]))) {
				sosuCnt++;
			}
		}
		System.out.println(sosuCnt);
		
	}
	
	public static boolean isSosu(int x) {
		for(int i = 2; i <= x; i++) {
			if(x != i && x % i == 0) {
				break;
			} else if(x == i && x % i == 0) {
				return true;
			}
		}
		return false;
	}
}
