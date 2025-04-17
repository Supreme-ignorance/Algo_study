import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int K;

    static List<Integer> selected = new ArrayList<>();
    static int LIMIT;
    static int[][] grid;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        K = kb.nextInt();
        LIMIT = N * 2;

        grid = new int[M][K];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < K; c++) {
                grid[r][c] = kb.nextInt();
            }
        }
        recur(1, 0);
        System.out.println(max);

    }

    static void recur(int cur, int cnt) {
        if (cur == LIMIT + 1) {
            if (cnt == N) {
                int total = 0;
                outer:
                for (int r = 0; r < M; r++) {
                    for (int c = 0; c < K; c++) {
                        if(!selected.contains(grid[r][c])) {
                            continue outer;
                        }
                    }
                    total++;
                }
                max = Math.max(max, total);
            }
            return;
        }

        selected.add(cur);
        recur(cur + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        recur(cur + 1, cnt);
    }
}
