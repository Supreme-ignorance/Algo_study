import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][]	map;
    static boolean[][] visited;
    static int R, C;
    static int max = 0;
    static int [][] deltas = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, 1}, {1, 1}, {1, 0}, {1,-1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int status = sc.nextInt();
                if (status == 0) {
                    map[r][c] = status;
                    continue;
                }
                if (status == 1)
                    map[r][c] = -1;
            }
        }

        // 1찾기 시작
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == -1) {
                    bfs(r, c, 0);
                    visited = new boolean[R][C];
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > max) {
                    max = map[r][c];
                }
            }
        }
        System.out.println(max);
    }

    private static void bfs(int row, int col, int status) {
        // 만약 0
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {row, col, status});

        while(!queue.isEmpty()) {
            int[] nowLoc = queue.poll();
            for (int d = 0; d < 8; d++) {
                int nr = nowLoc[0] + deltas[d][0];
                int nc = nowLoc[1] + deltas[d][1];
                if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0 || map[nr][nc] > nowLoc[2]) {
                        map[nr][nc] = nowLoc[2] + 1;
                        queue.add(new int[]{nr, nc, nowLoc[2] + 1});
                    }
                }
            }
        }
    }
}
