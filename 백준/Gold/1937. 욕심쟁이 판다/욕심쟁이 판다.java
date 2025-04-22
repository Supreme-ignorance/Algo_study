import java.util.Scanner;

public class Main {

    static int N;
    static int[][] grid;
    static int[][] dp;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        grid = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = kb.nextInt();
            }
        }

        dp = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                dp[r][c] = -1;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                max = Math.max(max, recur(r, c) + 1);
            }
        }

        System.out.println(max);
    }

    static int recur(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int max = 0;
        for (int d = 0; d < 4; d++) {
            int nextRow = r + dr[d];
            int nextCol = c + dc[d];
            if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] > grid[r][c]) {
                max = Math.max(max, recur(nextRow, nextCol) + 1);
            }
        }
        dp[r][c] = max;
        return dp[r][c];
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
