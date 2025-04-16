import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int K;

    static int[][] grid;
    static int max = Integer.MIN_VALUE;
    static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();
        grid = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        recur(0, 0);
        System.out.println(max);
    }

    static void recur(int cur, int cnt) {
        if (cur == N) {
            if (cnt == K) {
                int sum = 0;
                for (int i = 0; i < K; i++) {
                    int curIdx = selected.get(i);
                    for (int j = i + 1; j < K; j++) {
                        int nextIdx = selected.get(j);
                        sum += grid[curIdx][nextIdx];
                    }
                }
                max = Math.max(max, sum);
            }
            return;
        }

        selected.add(cur);
        recur(cur + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        recur(cur + 1, cnt);

    }
}
