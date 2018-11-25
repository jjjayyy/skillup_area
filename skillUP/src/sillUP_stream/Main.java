package sillUP_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동", 10),
				new Student("김길동", 20),
				new Student("유길동", 30)
				);
		
		double avg = list.stream()
				.mapToInt(Student :: getScore)
				.average()
				.getAsDouble();
		
		System.out.println("평균" + avg);
				
	}
}
