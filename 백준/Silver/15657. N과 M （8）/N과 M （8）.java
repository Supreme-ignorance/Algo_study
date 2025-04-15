import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer t = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(t.nextToken());
        M = Integer.parseInt(t.nextToken());
        arr = new int[N];
        selected = new int[M];
        t = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(t.nextToken());
        }
        Arrays.sort(arr);
        recur(0, 0);
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

        for (int i = start; i < N; i++) {
            selected[cur] = arr[i];
            recur(cur + 1, i);
        }
    }
}
