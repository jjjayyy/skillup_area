package CodingTest;

public interface Bank {
    public String getAccount(int price);

    default String findDormancyAccount() {
        return "으카운트";
    }

    static String getAuthAccount() {
        return "오쓰으카운트";
    }
}
