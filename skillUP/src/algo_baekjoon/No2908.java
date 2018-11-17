package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2908 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] strNumArr = br.readLine().split(" ");
		String temp = "";
		
		for(int i = 0; i < strNumArr.length; i++) {
			for(int j = 2; j >= 0; j--) {
				temp += strNumArr[i].charAt(j);
			}
				strNumArr[i] = temp;
				temp = "";
		}
		int num1 = Integer.parseInt(strNumArr[0]);
		int num2 = Integer.parseInt(strNumArr[1]);
		
		int result = (num1 > num2) ? num1 : num2;
		System.out.println(result);
	}
	
	
	/*
	 * 다른 풀이(참고용)
	 */
	
	/*
    StringBuffer sb = new StringBuffer(br.readLine());
    StringTokenizer st = new StringTokenizer(sb.reverse().toString()); // 거꾸로 읽어드림
    
    int intA = Integer.parseInt(st.nextToken());
    int intB = Integer.parseInt(st.nextToken());
    
    bw.write(String.valueOf(Math.max(intA, intB))); // 숫자 비교  
    */
}
