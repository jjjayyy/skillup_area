package skillUP_enum;

public class Main {
	public static void main(String[] args) {
        String data = "Banana";
        
        Fruit fruit = Fruit.valueOf(data);
 
        System.out.println("color : " + fruit.value_1 + " / num : " + fruit.value_2);
	}
	
    private enum Fruit{
        Apple("red", 1),
        Mango("yello", 2),
        Banana("green", 3);
 
        private String value_1;
        private int value_2;
 
        Fruit(String value_1, int value_2){
            this.value_1 = value_1;
            this.value_2 = value_2;
        }
    }
}
