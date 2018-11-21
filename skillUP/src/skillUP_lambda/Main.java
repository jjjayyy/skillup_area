package skillUP_lambda;

public class Main {

	public static void main(String[] args) {
		MyFunctionalInterface fi;
		MyFuncParam fp;
		MyFuncMultiParam fmp;
		
		//functional interface
		fi = ()->{
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> {System.out.println("method call2");};
		fi.method();
		
		fi = () -> {System.out.println("method call3");};
		fi.method();
		
		//functional interface (param)
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		fp = x -> {
			int result = x * 5;
			System.out.println(result);
		};
		fp.method(2);
		
		fp = x -> {System.out.println(x+5);};
		fp.method(2);
		
		//functional interface (multi param)
		System.out.println("::::::::::::::::::::::::::::::::::::::::");
		fmp = (x,y) -> {
			int result = x+y;
			return result;
		};
		System.out.println(fmp.mehtod(2, 5));
		
		fmp = (x,y) -> x + y;
		System.out.println(fmp.mehtod(2, 5));
		
	}
}
