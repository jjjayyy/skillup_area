package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10828 {
	/*
	 * push X: 정수 X를 스택에 넣는 연산이다.
	 * pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 * size: 스택에 들어있는 정수의 개수를 출력한다.
	 * empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	 * top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	 */


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack stack = new Stack();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
						
			String tempArr[] = br.readLine().split("\\s");
			
			switch (tempArr[0]) {
				case "push" : stack.push(Integer.parseInt(tempArr[1])); break;
				case "pop" : stack.pop(); break;
				case "size" : stack.size(); break;
				case "empty" : stack.empty(); break;
				case "top" : stack.top(); break;
			}
		}
	}
	
}

class Stack {
	
	private List<Integer> stack = new ArrayList<>();
	private int size = 0;
	
	public void push(int x) {
		stack.add(x);
		size++;
	}
	
	public void pop() {
		if(size == 0) {
			System.out.println(-1);
		} else {
			System.out.println(stack.get(size-1));
			stack.remove(size-1);
			size--;
		}
	}
	
	public void size() {
		System.out.println(size);
	}
	
	public void empty() {
		int empty = size == 0 ? 1 : 0;
		System.out.println(empty);
	}
	
	public void top() { 
		int top = size == 0 ? -1 : stack.get(size-1);
		System.out.println(top);
	}

}
