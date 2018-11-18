package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strArr = new String[N];
		
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			boolean isNotGroupWord = false;
			strArr[i] = br.readLine();
			String alpha = strArr[i];
			
			for(int j = 0; j < alpha.length() - 1; j++) {
				for(int k = j; k < alpha.length(); ++k) {
					
					if(k+1 < alpha.length() && alpha.charAt(j) == alpha.charAt(k+1)) {
						if(k != 0 && alpha.charAt(j) != alpha.charAt(k)){
							isNotGroupWord = true;
						}
					}
				}
			}
			if(!isNotGroupWord) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}



/*
 *     
 *     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int result = 0;
 
        // solution
        while(t-- > 0) {
            String input = br.readLine().trim();
            if(checkGroup(input)) {
                result++;
            }
        }
        
        System.out.print(result);
    }
    
    private static boolean checkGroup(String input) {
        boolean[] alpabet = new boolean[26];
        int length = input.length();
        
        int i;
        for(i=0; i<length; i++) {
            char temp = input.charAt(i);
            if(alpabet[temp-'a']) {
                // 이미 나온 단어
                return false;
            }else {
                if(i< length-1 && temp != input.charAt(i+1)) {
                    alpabet[temp-'a'] = true;
                }
                
            }// end if
        }// end for
        
        return true;
    }


	출처: https://hongku.tistory.com/244 [IT에 취하개 :: 취미로 하는 개발자]
	
	boolean 배열에 알파벳을 넣어서 이전 알파벳이랑 같지 않으면서 한번 나왔던 알파벳은 true로 리턴
	나온 단어가 있으면 false 리턴하고 제외 시켜버림
 * 
 */
