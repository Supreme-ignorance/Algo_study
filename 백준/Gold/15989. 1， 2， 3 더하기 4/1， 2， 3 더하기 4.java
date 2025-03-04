import java.util.Scanner;

public class Main {
    static final int MAX_N = 10_000;

    static int N;
    static int[][] dp = new int[MAX_N + 1][4];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= MAX_N; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        for (int i = 0; i < N; i++) {
            int value = kb.nextInt();
            int sum = 0;
            for (int d = 1; d <= 3; d++) {
                sum += dp[value][d];
            }
            System.out.println(sum);
        }
    }
}
