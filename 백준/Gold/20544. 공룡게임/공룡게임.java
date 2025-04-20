import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int MOD = 1_000_000_007;
    static int N;
    static int[][][][] dp;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        dp = new int[3][3][N][N];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = 0; l < N; l++) {
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }

        System.out.println(recur(1, 0, 0, 0));
    }

    // prev은 바로 전, prev2는 두 번째 전, cnt는 높이가 2인 선인장
    static int recur(int cur, int prev, int prev2, int cnt) {
        // 기저조건
        if (cur == N) {
            if (cnt >= 1) {
                return 1;
            }
            return 0;
        }

        if (dp[prev2][prev][cur][cnt] != -1) {
            return dp[prev2][prev][cur][cnt];
        }

        // 바로 전 두번째 전이 선인장이면 여기선 무조건 0으로 가야함
        if (prev != 0 && prev2 != 0) {
            dp[prev2][prev][cur][cnt] = recur(cur + 1, 0, prev, cnt) % MOD;
        }
        // 그게 아니라면
        else {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                if (prev + i >= 4) continue;
                int level2 = i == 2 ? 1 : 0;
                sum += (recur(cur + 1, i, prev, cnt + level2) % MOD);
                sum %= MOD;
            }
            dp[prev2][prev][cur][cnt] = sum;
        }
        return dp[prev2][prev][cur][cnt];
    }
}