package algo_programmers;

public class Target_Number {
    static int answer = 0;
    public static void main(String[] args) {
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        dfs(numbers, target, 0);
        System.out.println(answer);
    }

    public static void dfs(int[] numbers, int target, int node) {
        if(node == numbers.length) {
            int sum = 0;
            for(int num : numbers) {
                sum += num;
            }
            if(sum == target) {
                answer++;
            }
        } else {
            numbers[node] *= 1;
            dfs(numbers, target, node+1);

            numbers[node] *= -1;
            dfs(numbers, target, node+1);
        }
    }
}
