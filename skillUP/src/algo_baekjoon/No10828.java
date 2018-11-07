package algo_baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10828 {
	/*
	 * push X: 정수 X를 스택에 넣는 연산이다.
	 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * size: 스택에 들어있는 정수의 개수를 출력한다.
	 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		String[] order = new String[N];
		int printNum = 0;

		for(int i = 0; i < N; i++) {
			order[i] = br.readLine();
		}

		bw.write(Integer.toString(printNum));
		bw.flush();
		bw.close();
	}

	int cnt = 0;
	int[] stack = null;

	public void push(int stackElem) {
		stack = new int[top()];
			stack[cnt] = stackElem;
			cnt++;
	}

	public int pop() {
		if(empty() == 1) {
			return -1;
		}
		int num = stack[stack.length - 1];
		stack[stack.length-1] = 0;
		return num;
	}

	public int size() {
		return stack.length;
	}

	public int empty() {
		if(stack.length==0) {
			return 1;
		}
		return 0;
	}

	public int top() {
		if(empty() == 1) {
			return -1;
		}
		return stack[stack.length - 1];
	}

}
