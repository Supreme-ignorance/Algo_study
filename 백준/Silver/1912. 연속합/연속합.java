import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        String line = br.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line, " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = numbers[0];
        int max = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(numbers[i], dp[i - 1] + numbers[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}