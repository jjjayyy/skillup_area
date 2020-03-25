package skillUP_class;

public class Animal {

	String food;
	int location;
	
	public void makeNoise() {
		System.out.println("grr");
	}
	
	public void eat() {
		System.out.println("meat");
	}



	public static void main(String[] args) {
		Tiger tiger = new Tiger
				.Builder("tygen")
				.age(2)
				.sex("M")
				.build();
		System.out.println(tiger.getSex());
	}
}
