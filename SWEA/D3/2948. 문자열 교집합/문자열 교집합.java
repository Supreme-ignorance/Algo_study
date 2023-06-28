import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine());
            Set<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(tokenizer.nextToken());
            }

            int count = 0;
            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                if (set.contains(tokenizer.nextToken())) {
                    count++;
                }
            }

            System.out.println("#" + tc + " " + count);
        }
    }
}