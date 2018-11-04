package skillUP_static;

public class Main {

	public static void main(String[] args) {
		Chicken c = new Chicken();
		Chicken k = new Chicken();
		
		for(int i=0; i<3; i++) {
			
			System.out.print("c = " + c.chicCnt() + " / ");
			System.out.println("k = " + k.chicCnt() + " / ");
			System.out.println(Chicken.chicFoot());

		}
		
	}
}
