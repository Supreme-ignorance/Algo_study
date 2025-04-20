import java.util.Scanner;

public class Main {

    static int N;
    static int[][] grid;
    static int[][] dp;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        grid = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = kb.nextInt();
            }
        }

        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < 3; i++) {
            recur(0, i);
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[0][i]);
        }
        System.out.println(min);
    }

    static int recur(int cur, int prev) {
        if (cur == N) {
            return 0;
        }
        if (dp[cur][prev] != -1) {
            return dp[cur][prev];
        }

        int ret = (int) 1e9; // 절대 선택될 수 없는 값으로 설정
        for (int i = 0; i < 3; i++) {
            if (prev == i) continue;
            ret = Math.min(ret, recur(cur + 1, i) + grid[cur][i]);
        }
        dp[cur][prev] = ret;
        return dp[cur][prev];
    }
}
