package CodingTest;

public class SCF_Test2 {
    static int cnt = 0;
    boolean[] visited;

    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int length = Integer.parseInt(br.readLine());
//        String points = br.readLine();

        int length = 3;
        String points = "111";
        dfs(0, points, length);
    }

    public static void dfs(int start, String points, int length) {
        if(start == length - 1) {
            cnt++;
            return;
        }

        if(start+1 < length && points.charAt(start+1) != 0) {

        }

        if(start+2 < length && points.charAt(start+2) != 0) {


        }

        System.out.println(points.charAt(start));
    }

    // 1칸 -> length 넘기거나 0이면 못감
    // - length 넘김 = 종료
    // - 0 = 2칸 경로 ㄱ
    // 2칸 -> length 넘기거나 0이면 못가
    // - length 넘김 or 0이면 1칸 경로 ㄱ
}
