package CodingTest;

public class TOSS_Test1 {

    public static void main(String[] args) {
        solution(10000, 1000, 100);
    }

    public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

// 부가가치세 = 과세금액 * 0.1  (소수점 첫째자리 올림)
// 과세금액  = 공급가액 - 비과세금액 (1원이면 부가가치세 0원처리)
// 공급대가 = 공급가액 + 부가가치세 (주문금액 - 봉사료)
// 공급가액 = x + ((x - 비과세금액) * 0.1) = 주문금액 - 봉사료

        long supplyFee = orderAmount - serviceFee;          //공급대가
        double supplyAmt = (supplyFee + 0.1 * taxFreeAmount) / 1.1; //공급가액

        double taxAmount = supplyAmt - taxFreeAmount;

        if(supplyFee - taxFreeAmount == 1) {
            return 0;
        }

        return (long) Math.ceil(taxAmount * 0.1);
    }
}
