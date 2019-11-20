package skillUP_stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_Null_Test {

    public static void main(String[] args) {

        String[] strArr = {"a", "b", "c", "d"};
        String[] nullArr = null;
        String[] strNullArr = {"a", null, "c", "d"};
        String[] strArr2 = {"a", "c", "d"};

        Arrays.asList(strArr).stream().filter(str -> "b".equals(str)).map(str -> "@@@" + str).forEach(System.out::println);
        System.out.println(Optional.ofNullable(strArr2).filter(str -> "d".equals(str)).map(str -> "@@@" + str).orElse(null));
        //Optional.ofNullable(nullArr).map(Collection::stream).orElseGet(Stream::empty);
        //Arrays.asList(nullArr).stream().filter(str -> "b".equals(str)).forEach(System.out::println);
        String test = Arrays.asList(strNullArr).stream().filter(str -> "b".equals(str)).map(str -> "@@@" + str).collect(Collectors.joining());
        System.out.println(test == null);
        System.out.println("testtest");

    }
}
