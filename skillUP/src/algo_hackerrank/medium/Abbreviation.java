package algo_hackerrank.medium;

public class Abbreviation {
    public static void main(String[] args) {
//        String a = "hHhAhhcahhacaccacccahhchhcHcahaahhchhhchaachcaCchhchcaccccchhhcaahhhhcaacchccCaahhaahachhacaahhaachhhaaaCalhhchaccaAahHcchcazhachhhaaahaahhaacchAahccacahahhcHhccahaachAchahacaahcahacaahcahacaHhccccaahaahacaachcchhahhacchahhhaahcacacachhahchcaAhhcaahchHhhaacHcacahaccccaaahacCHhChchhhahhchcahaaCccccahhcaachhhacaaahcaaaccccaacaaHachaahcchaahhchhhcahahahhcaachhchacahhahahahAahaAcchahaahcaaaaahhChacahcacachacahcchHcaahchhcahaachnachhhhcachchahhhacHhCcaHhhhcaCccccaaahcahacahchahcaachcchaachahhhhhhhhcahhacacCcchahccaaaaaHhhccaAaaaCchahhccaahhacaccchhcahhcahaahhgacahcahhchcaaAccchahhhaahhccaaHcchaccacahHahChachhcaaacAhacacaacacchhchchacchchcacchachacaahachccchhhaccahcacchaccaahaaaccccccaaaaaaaHhcahcchmcHchcchaaahaccchaaachchHahcaccaaccahcacacahAhaacaacaccaccaaacahhhcacAhaCchcaacCcccachhchchcchhchahchchahchchhchcacaachahhccacachaAhaaachchhchchchhaachahaahahachhaaaccacahhcacchhhaaachaaacAahhcachchachhhcacchacaaChCahhhccahChaachhcahacchanaaacchhhccacacchcahccchAcahacaaachhacchachccaaHaca ac AhahcCh";
//        String b = "HAHHCHAACCCAHCHHAHHAHCACCHCCHHCAAHHCACCCAHHHACAAHHHHCHHCAHHAHHAAAHAACAAHAHHCAHAHACHACHCHACACHAAHHAAAHCAHHACACAACHHHCHAHCAHCHHHAHAHACCAAAHCHHCHHCCAACCCCAACHACAACAAHACHCHAHHACCHCAHHHAAACHACAACHCACACAHHCCHAHACCCACCAACHCHHHCCCCCHCCAHHCAAHHAHHHHHHHAACCCCAHCCAAAAAHHHAAAACCAHHCAHACACCHHCHAHAHHCHAACHHHHHCCHCCAHAHCHCAAACCACCCCHACCACHHACHHACACHACCAACCCCAAAAHHAHCHHHCCAHCCHACHHAHCCACACCHAHAAACACCCCAHCCAHACCCCCCHCCHHCHHHHCHCHCAHHHACHAHAACCCAAAACHAACAAAHHAAHAAAHACHHCACHCCHCHAACHACACHHCCCCCAHCACHAAAHCHCAHACAAC";
        String a = "beFgH";
        String b = "EFG";

        System.out.println(abbreviation(a,b));
    }

    static boolean isEqual(char a, char b){
        return a == b || Character.toUpperCase(a) == b;
    }

    static String abbreviation(String a, String b) {
        boolean[][] dp = new boolean[a.length()+1][b.length()+1];
        dp[0][0] = true;

        for(int i=1; i < a.length()+1; i++){
            for(int j=0; j < b.length()+1; j++){
                if(j > 0 && dp[i-1][j-1] && isEqual(a.charAt(i-1), b.charAt(j-1))){
                    dp[i][j] = true;
                }
                if(Character.isLowerCase(a.charAt(i-1)) && dp[i-1][j]){
                    dp[i][j] = true;
                }
            }
        }
        return dp[a.length()][b.length()] ? "YES" : "NO";
    }



//    public static String abbreviation(String a, String b) {
//        // Write your code here
//        int aIdx = 0;
//        int bIdx = 0;
//        String aCap = a.toUpperCase();
//
//        while(aIdx != a.length() && bIdx != b.length()) {
//            if(aCap.charAt(aIdx) != b.charAt(bIdx)) {
//                aIdx++;
//                continue;
//            }
//            aIdx++;
//            bIdx++;
//        }
//
//        if(aIdx == a.length() && bIdx != b.length()) {
//            return "NO";
//        }
//
//        if(aIdx != a.length() && bIdx == b.length()) {
//            for(int i = aIdx; i < a.length(); i++) {
//                if(Character.isUpperCase(a.charAt(i))) {
//                    System.out.println(a.length());
//                    System.out.println(a.charAt(i));
//                    return "NO";
//                }
//            }
//        }
//
//        return "YES";
//    }
}
