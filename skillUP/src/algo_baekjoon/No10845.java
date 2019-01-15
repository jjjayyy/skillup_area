package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue queue = new Queue();
		
		for(int i = 0; i < N; i++) {
			
			String[] order = br.readLine().split("\\s");
			
			switch(order[0]) {
			case "push" : queue.push(Integer.parseInt(order[1])); break;
			case "pop" : queue.pop(); break;
			case "size" : queue.size(); break;
			case "empty" : queue.empty(); break;
			case "front" : queue.front(); break;
			case "back" : queue.back(); break;
			}
			
		}
	}
}

class Queue {
	private List<Integer> queue = new ArrayList<>();
	private int size = 0;
	
	public void push(int x) { 
		queue.add(x);
		size++;
	};
	
	public void pop() {
		
		if(queue.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(queue.get(0));
			queue.remove(0);
			size--;
		}
	}
	
	public void size() {
		System.out.println(size);
	}
	
	public void empty() {
		int empty = size==0 ? 1 : 0;
		System.out.println(empty);
	}
	
	public void front() {
		int front = size==0 ? -1 : queue.get(0);
		System.out.println(front);
	}
	
	public void back() { 
		int back = size==0 ? -1 : queue.get(size-1);
		System.out.println(back);
	}
}
