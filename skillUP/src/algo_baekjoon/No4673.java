package algo_baekjoon;

public class No4673 {

	public static void main(String[] args) {
		boolean[] isNotSelfNum = new boolean[10001];
		for(int i = 1; i <= 10000; i++) {
			if(dn(i) <= 10000) {
				isNotSelfNum[dn(i)] = true;
			}
		}
		
		for(int j = 1; j <= 10000; j++) {
			if(!isNotSelfNum[j]) {
				System.out.println(j);
			}
		}
	}

	public static int dn(int n) {
		int dn = n;
			
		while(n > 0) {
			dn += n % 10;
			n /= 10;
		}
		
		return dn;
	}
	
}
