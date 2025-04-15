import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static int max = (int) -1e9;

    // N개에서 N개 뽑기 순서가 다르면 다르다
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        recur(0);
        System.out.println(max);
    }

    static void recur(int cur) {
        // 기저조건
        if (cur == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(selected[i] - selected[i + 1]);
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            selected[cur] = arr[i];
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }
}
