package skillUP_for;

public class Main {

	public static void main(String[] args) {
		int index = 0;
		int[] array = new int[3];
		array[0] = 2;
		array[1] = 5;
		array[2] = 8;
		
		Loop1 : for(int i = 0; i < array.length; i++) {
			for(int j = index; j < 10; j++) {
				if(array[i] == j) {
					System.out.println(array[i]);
					index = j + 1;
					continue Loop1;
				}
			}
		}
	}
}
