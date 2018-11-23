package skillUP_lambda;

import java.util.function.ToIntBiFunction;

public class ArgumentMethodReferencesExample {

	public static void main(String[] args) {
		ToIntBiFunction<String, String> function;
		
		function = (a, b) -> a.compareToIgnoreCase(b);
		print(function.applyAsInt("Java8", "Java8"));
		
		function = String :: compareToIgnoreCase;
		print(function.applyAsInt("Java8", "Java8"));
	}
	
	public static void print(int order) {
		if(order < 0) {
			System.out.println("사전순으로 먼저 옴");
		} else if(order == 0) {
			System.out.println("동일한 문자열");
		} else {
			System.out.println("사전순으로 나중에 옴");
		}
	}
}
