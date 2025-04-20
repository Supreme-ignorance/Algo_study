import java.util.Scanner;

public class Main {

    static final int MOD = 100_000;

    static int ROW;
    static int COL;

    static int[][][][] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ROW = kb.nextInt();
        COL = kb.nextInt();

        dp = new int[ROW][COL][2][2];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        dp[r][c][i][j] = -1;
                    }
                }
            }
        }

        System.out.println((recur(0, 1, 0, 0) + recur(1, 0, 1, 1)) % MOD);
    }

    // 0 == ㅡ 로 가는거, 1 == | 로 가는거
    static int recur(int r, int c, int prev2, int prev) {
        // 기저조건
        if (r == ROW - 1 && c == COL - 1) {
            dp[r][c][prev2][prev] = 1;
            return dp[r][c][prev2][prev];
        }

        if (ROW <= r || COL <= c) {
            return  0;
        }

        if (dp[r][c][prev2][prev] != -1) {
            return dp[r][c][prev2][prev];
        }

        if (prev2 == prev) {
            dp[r][c][prev2][prev] = (recur(r, c + 1, prev, 0) + recur(r + 1, c, prev, 1)) % MOD;
            return dp[r][c][prev2][prev];
        }
        // 둘이 다르면
        else {
            if (prev2 == 0) {
                return dp[r][c][prev2][prev] = recur(r + 1, c, prev, 1) % MOD;
            }
            else {
                return dp[r][c][prev2][prev] = recur(r, c + 1, prev, 0) % MOD;
            }
        }
    }
}
