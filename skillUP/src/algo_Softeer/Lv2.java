package algo_Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lv2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] houseArr = br.readLine().split(" ");
//        List<Integer> list = Arrays.stream(houseArr)
//                .mapToInt(s -> Integer.parseInt(s))
//                .sorted()
//                .boxed()
//                .collect(Collectors.toList());

        int max = 1;
        for(int i = 2; i <= 100; i++) {
            int num = 0;
            for(int j = 0; j < n; j++) {
                if(Integer.parseInt(houseArr[j]) % i == 0) {
                    num++;
                }
                max = Math.max(max, num);
            }
        }
        System.out.println(max);

//        for(int i = 2; i < list.get(list.size()-1)/2; i++) {
//            int num = 0;
//            for(int j = idx; j < n; j++) {
//                if(list.get(j) % i == 0) {
//                    num++;
//                }
//                max = Math.max(max, num);
//            }
//        }

//        for(int i = 0; i < n-1; i++) {
//            int base = list.get(i);
//            int num = 1;
//            for(int j = i+1; j < n; j++) {
//                if(list.get(j) % base == 0) {
//                    num++;
//                }
//                max = Math.max(max, num);
//            }
//        }
        System.out.println(max);
    }


//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] nm = br.readLine().split(" ");
//        int n = Integer.parseInt(nm[0]);
//        int m = Integer.parseInt(nm[1]);
//
//        String[] matrixN = new String[n];
//        for(int i = 0; i < n; i++) {
//            matrixN[i] = br.readLine().replaceAll(" ","");
//        }
//
//        String[] firstAttack = br.readLine().split(" ");
//        String[] secondAttack = br.readLine().split(" ");
//
//        int firstAttackStart = Integer.parseInt(firstAttack[0]);
//        int firstAttackEnd = Integer.parseInt(firstAttack[1]);
//        int secondAttackStart = Integer.parseInt(secondAttack[0]);
//        int secondAttackEnd = Integer.parseInt(secondAttack[1]);
//
//        int result = 0;
//        for(int i = 0; i < n; i++) {
//            int line1 = 0;
//            for(int j = 0; j < matrixN[i].length(); j++) {
//                if (matrixN[i].charAt(j) == '1') {
//                    line1++;
//                }
//            }
//
//            if(firstAttackStart <= i && firstAttackEnd > i) {
//                line1--;
//            }
//
//            if(secondAttackStart <= i && secondAttackEnd > i) {
//                line1--;
//            }
//
//            if(line1 < 0) line1 = 0;
//
//            result += line1;
//        }
//
//        System.out.println(result);
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        String[] dArr = new String[n];
//
//        for(int i = 0; i < n; i++) {
//            dArr[i] = br.readLine();
//        }
//
//        Comparator<String> compareCustom = new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//
//                // 소수점 위치 찾기
//                int dotIndex1 = s1.indexOf('.');
//                int dotIndex2 = s2.indexOf('.');
//
//                // 1. 정수 부분을 기준으로 먼저 비교
//                int intPart1 = (dotIndex1 == -1) ? Integer.parseInt(s1) : Integer.parseInt(s1.substring(0, dotIndex1));
//                int intPart2 = (dotIndex2 == -1) ? Integer.parseInt(s2) : Integer.parseInt(s2.substring(0, dotIndex2));
//
//                if (intPart1 != intPart2) {
//                    return Integer.compare(intPart1, intPart2);
//                }
//
//                // 2. 정수 부분이 같다면, 소수점이 있으면 더 큰 값으로 취급
//                if (dotIndex1 != -1 && dotIndex2 != -1) {
//                    // 소수 부분의 길이를 비교
//                    String frac1 = s1.substring(dotIndex1 + 1);  // 소수점 이후 부분
//                    String frac2 = s2.substring(dotIndex2 + 1);  // 소수점 이후 부분
//                    int len1 = frac1.length();
//                    int len2 = frac2.length();
//
//                    // 소수 부분 길이를 비교
//                    if (len1 != len2) {
//                        return Integer.compare(len1, len2);
//                    }
//
//                    // 길이가 같다면 실제 값을 비교
//                    return frac1.compareTo(frac2);
//                }
//
//                // 3. 소수 부분이 없으면, 소수 부분이 있는 수가 더 큰 수로 취급
//                if (dotIndex1 != -1) {
//                    return 1;  // s1에는 소수점이 있지만 s2에는 소수점이 없으면 s1이 더 큼
//                } else if (dotIndex2 != -1) {
//                    return -1; // s2에는 소수점이 있지만 s1에는 소수점이 없으면 s2가 더 큼
//                }
//
//                // 4. 정수 부분과 소수 부분까지 동일하면, 그 숫자는 동일하므로 0 반환
//                return 0;
//
//
////                String[] number1DotArr = o1.split("\\.");
////                String[] number2DotArr = o2.split("\\.");
////
////                int num1Left = Integer.parseInt(number1DotArr[0]);
////                int num2Left = Integer.parseInt(number2DotArr[0]);
////
////                if(num1Left > num2Left) return 1;
////                if(num1Left < num2Left) return -1;
////
////                if(number1DotArr.length > number2DotArr.length) return 1;
////                if(number1DotArr.length < number2DotArr.length) return -1;
////
////                int num1Right = Integer.parseInt(number1DotArr[1]);
////                int num2Right = Integer.parseInt(number2DotArr[1]);
////
////                if(num1Right > num2Right) return 1;
////                if(num1Right < num2Right) return -1;
//
////                return 0;
//            }
//        };
//
//        List<String> list = new ArrayList<>(Arrays.asList(dArr));
//        list.sort(compareCustom);
//
//        for(String numStr : list) {
//            System.out.println(numStr);
//        }
//    }
}
