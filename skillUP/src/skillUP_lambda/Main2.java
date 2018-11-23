package skillUP_lambda;

import java.util.function.Function;
import java.util.function.IntSupplier;

public class Main2 {

	public static void main(String[] args) {
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		
		Function<String, Integer> functionA;
		
		int num = intSupplier.getAsInt();
		System.out.println("눈의 수 : " + num);
	}
}
