package CodingTest;

import java.math.BigDecimal;

public class CJO_Test1 {

    public static void main(String[] args) {
        int[] x = {5};
        int[] y = {5};
        int[] r = {5};
        int[] v = {92, 83, 14, 45, 66, 37, 28, 9, 10, 81};

        System.out.println(solution(x, y, r, v));

        System.out.println(Math.pow(5,2) >= (Math.pow(5-8,2) + Math.pow(5-9,2)));

    }

    public static int solution(int[] x, int[] y, int[] r, int[] v) {

        int sq_i = Integer.MAX_VALUE;
        int sq_r = 0;
        int sq_b = Integer.MAX_VALUE;
        int sq_t = 0;

        for(int i = 0; i < x.length; i++) {
            sq_i = Math.min(sq_i, x[i]-r[i]);
            sq_r = Math.max(sq_r, x[i]+r[i]);
            sq_b = Math.min(sq_b, y[i]-r[i]);
            sq_t = Math.max(sq_t, y[i]+r[i]);
        }

        int[][] point_v = new int[v.length/2][2];


        for(int i = 0; i < v.length; i++) {
            int temp = i % 2 == 0 ? sq_i + v[i] % (sq_r - sq_i)
                                  : sq_b + v[i] % (sq_t - sq_b);

            point_v[i/2][i%2] = temp;
        }

        boolean isInnerCircle = false;
        int cnt = 0;
        for(int i = 0; i < point_v.length; i++) {
            isInnerCircle = false;

            for(int j = 0; j < x.length; j++) {
                isInnerCircle = Math.pow(r[j],2) >= (Math.pow(x[j]-point_v[i][0],2) + Math.pow(y[j]-point_v[i][1],2));
                if(isInnerCircle) {
                   break;
                }
            }
            if(!isInnerCircle) {
                cnt++;
            }
        }

        BigDecimal bigTemp = new BigDecimal(String.valueOf(point_v.length-cnt)).divide(new BigDecimal(String.valueOf(point_v.length)));
        return (int) (bigTemp.doubleValue() * (sq_r - sq_i) * (sq_t - sq_b));
    }
}
