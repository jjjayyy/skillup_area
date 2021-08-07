package CodingTest;

public class Test2 {

    public static void main(String[] args) {

//        String regExp = "^[a-z]{1,6}+[_]?+[0-9]{0,4}+@hackerrank.com+$";
//        System.out.println("dadddd2_@hackerrank.com".matches(regExp));

        String str = "uid1234님이 들어왔습니다.";
        str = str.replace("uid1234", "Prodo");
        System.out.println(str.hashCode());
    }
}
