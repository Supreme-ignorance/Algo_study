import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        int sqrt = (int) Math.sqrt(N);
        System.out.println(recur(N));
    }
    static int recur(int result) {
        // 기저조건
        if(result <= 3) {
            return dp[result] = result;
        }

        if (dp[result] != -1) {
            return dp[result];
        }

        int min = Integer.MAX_VALUE;
        int sqrt = (int) Math.sqrt(result);
        for (int i = sqrt; i > 1; i--) {
            int nextResult = result - (i * i);
            min = Math.min(min, recur(nextResult) + 1);
        }
        dp[result] = min;
        return dp[result];
    }

//    static int recur(int result, int sqrt) {
//        // 기저조건
//        if(result <= 3) {
//            return dp[result] = result;
//        }
//
//        if (dp[result] != -1) {
//            return dp[result];
//        }
//
//        int min = Integer.MAX_VALUE;
//        for (int i = sqrt; i > 1; i--) {
//            int nextResult = result - (i * i);
//            min = Math.min(min, recur(nextResult, (int) Math.sqrt(nextResult)) + 1);
//        }
//        dp[result] = min;
//        return dp[result];
//    }
}
