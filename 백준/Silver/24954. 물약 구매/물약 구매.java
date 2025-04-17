import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] prices;
    static int[][] grid;

    static int[] selected;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        prices = new int[N + 1];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            prices[i] = Integer.parseInt(tokenizer.nextToken());
        }

        grid = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            int cnt = Integer.parseInt(br.readLine());
            for (int c = 0; c < cnt; c++) {
                tokenizer = new StringTokenizer(br.readLine(), " ");
                int col = Integer.parseInt(tokenizer.nextToken());
                int discount = Integer.parseInt(tokenizer.nextToken());
                grid[r][col] = discount;
            }
        }
        selected = new int[N + 1];
        visited = new boolean[N + 1];

        recur(1);
        System.out.println(min);
    }

    static void recur(int cur) {
        // 기저조건
        if (cur == N + 1) {
            int sum = 0;
            int[] discounts = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                int idx = selected[i];
                // 1원보다 더 할인되면 1로 통일
                if (prices[idx] - discounts[idx] <= 0) {
                    sum += 1;
                }
                else { // 할인된 가격 적용
                    sum += (prices[idx] - discounts[idx]);
                }
                // 산 물약의 할인 정책을 적용
                for (int c = 1; c <= N; c++) {
                    discounts[c] += grid[idx][c];
                }
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            selected[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }
}
