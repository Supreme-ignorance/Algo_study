import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] days = new int[N + 1];
        int[] values = new int[N + 1];
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());

            days[i] = day;
            values[i] = value;
        }

        int[] dp = new int[N + 1];
        for (int i = (dp.length - 1) - 1; i >= 0; i--) {
            if (i + days[i] < dp.length) {
                dp[i] = Math.max(dp[i + 1], dp[i + days[i]] + values[i]);
            }
            else { //선택을 못하니
                dp[i] = dp[i + 1];
            }
        }
        System.out.println(dp[0]);
    }
}