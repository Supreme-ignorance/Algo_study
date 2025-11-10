import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] grid;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            grid[i][0] = Integer.parseInt(tokenizer.nextToken());
            grid[i][1] = Integer.parseInt(tokenizer.nextToken());
            grid[i][2] = Integer.parseInt(tokenizer.nextToken());
        }

        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < 3; i++) {
            recur(0, i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[0][i]);
        }
        System.out.println(min);
        
    }

    // 현재는 앞서 최소비용으로 칠해왔음
    static int recur(int cur, int prev) {
        // 마지막은 칠할 것이 없으므로 0에서 시작한다.
        if (cur == N) {
            return 0;
        }

        // 앞으로 최소비용으로 칠할 것을 이미 계산했다면
        if (dp[cur][prev] != -1) {
            return dp[cur][prev];
        }

        // 앞으로 최소비용으로 칠할 것을 아직 계산하지 않았다면
        int min = (int) 1e9;
        for (int i = 0; i < 3; i++) {
            if (i == prev) continue;
            min = Math.min(min, recur(cur + 1, i) + grid[cur][i]);
        }
        dp[cur][prev] = min;
        return dp[cur][prev];
    }
}
