package algo_baekjoon;

public class No4673 {

	public static void main(String[] args) {
		
		boolean[] isNotSelfNum = new boolean[10001];
		
		for(int i = 0; i < 10000; i++) {
			int snum = selfNum(i);
			if(snum <= 10000) {
				isNotSelfNum[snum] = true;
			}
		}
		
		for(int i = 1; i<isNotSelfNum.length; i++) {
			if(!isNotSelfNum[i]) {
				System.out.println(i);
			}
		}
	}
	
	public static int selfNum(int num) {
		
		int snum = num;
		while(num > 0) {
			snum += num % 10;
			num /= 10;
		}
		return snum;
	}
}
