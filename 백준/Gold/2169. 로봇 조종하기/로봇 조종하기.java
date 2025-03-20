import java.util.Scanner;

public class Main {

    static final int MAX = 1_000;
    static final int MIN_VALUE = (int) -1e9;
    static int[][] grid = new int[MAX][MAX];
    static boolean[][][] visited = new boolean[3][MAX][MAX];
    static int[][][] dp = new int[3][MAX][MAX];

    static int N;
    static int M;
    static int ans;

    static int[] dr = {1, 0, 0};
    static int[] dc = {0, 1, -1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        init();

        for (int r = 1; r < N; r++) {
            for (int c = 0; c < M; c++) {
                dp[0][r][c] = Math.max(Math.max(dp[0][r - 1][c], dp[1][r - 1][c]), dp[2][r - 1][c]) + grid[r][c];
            }
            for (int c = 1; c < M; c++) {
                dp[1][r][c] = Math.max(dp[0][r][c - 1], dp[1][r][c - 1]) + grid[r][c];
            }
            for (int c = (M - 1) - 1; c >= 0; c--) {
                dp[2][r][c] = Math.max(dp[0][r][c + 1], dp[2][r][c + 1]) + grid[r][c];
            }
        }

        System.out.println(Math.max(dp[0][N - 1][M - 1], dp[1][N - 1][M - 1]));
    }

    static void init() {
        for (int t = 0; t < 3; t++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    dp[t][r][c] = MIN_VALUE;
                }
            }
        }

        dp[0][0][0] = grid[0][0];
        dp[1][0][0] = grid[0][0];
        dp[2][0][0] = grid[0][0];
        for (int c = 1; c < M; c++) {
            dp[1][0][c] = dp[1][0][c - 1] + grid[0][c];
        }
    }
}
