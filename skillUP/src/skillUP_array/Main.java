package skillUP_array;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {

		String[] temp = {"a", "b", "c"};

		List<String> tempList = Arrays.asList(temp);

		System.out.println(Arrays.stream(temp).filter(temps -> "b".equals(temps)));

	}




}
