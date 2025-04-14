import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        selected = new int[M];
        recur(0, 1);
        System.out.println(sb.toString());
    }

    static void recur(int cur, int start) {
        if (cur == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            selected[cur] = i;
            recur(cur + 1, i);
        }
    }
}
