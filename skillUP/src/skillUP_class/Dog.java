package skillUP_class;

public class Dog extends Canine implements Pet{

	@Override
	public void play() {
		System.out.println("dog play");
		
	}

	@Override
	public void beFriendly() {
		System.out.println("dog friend");
		
	}

}
