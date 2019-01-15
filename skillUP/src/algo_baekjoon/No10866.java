package algo_baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Deque deque = new Deque();
		
		for(int i = 0; i < N; i++) {
			String[] order = br.readLine().split("\\s");
			
			switch(order[0]) {
				case "push_front" : deque.push_front(Integer.parseInt(order[1])); break;
				case "push_back" : deque.push_back(Integer.parseInt(order[1])); break;
				case "pop_front" : deque.pop_front(); break;
				case "pop_back" : deque.pop_back(); break;
				case "size" : deque.size(); break;
				case "front" : deque.front(); break;
				case "back" : deque.back(); break;
				case "empty" : deque.empty(); break;
			}
		}
	}
}

class Deque {
	
	private List<Integer> deque = new ArrayList<>();
	private int size = 0;
	
	public void push_front(int x) {
		deque.add(0, x);
		size++;
	}
	
	public void push_back(int x) {
		deque.add(x);
		size++;
	}
	
	public void pop_front() {
		if(size==0) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(0));
			deque.remove(0);
			size--;
		}		
	}
	
	public void pop_back() {
		if(size==0) {
			System.out.println(-1);
		} else {
			System.out.println(deque.get(size-1));
			deque.remove(size-1);
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
		int front = size==0 ? -1 : deque.get(0);
		System.out.println(front);
	}
	
	public void back() {
		int back = size==0 ? -1 : deque.get(size-1);
		System.out.println(back);
	}
}
