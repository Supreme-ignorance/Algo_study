import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int pointer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            items[i] = new Item(weight, value);
        }

        int[][] dp = new int[N][K + 1];
        for (int i = 0; i <= K; i++) { //첫번째 물건 담기
            if (i >= items[0].weight) {
                dp[0][i] = items[0].value;
                continue;
            }
            dp[0][i] = 0;
        }

        for (int i = 1; i < N; i++) {
            Item item = items[i];
            for (int j = 0; j <= K; j++) {
                if (item.weight > j) { //아이템의 무게가 커서 넣을 수 없을 경우
                    dp[i][j] = dp[i - 1][j];
                }
                else { //아이템의 무게를 넣을 수 있을 경우
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - item.weight] + item.value);
                }
            }
        }
        System.out.println(dp[N - 1][K]);


    }

    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}