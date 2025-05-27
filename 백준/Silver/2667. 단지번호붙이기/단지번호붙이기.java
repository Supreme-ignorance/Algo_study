import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }

        visited = new boolean[N][N];
        int cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] == 1) {
                    cnt++;
                    dfs(r, c, cnt);
                }
            }
        }

        int[] count = new int[cnt + 1];

        System.out.println(cnt);
        for (int i = 1; i <= cnt; i++) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == i) {
                        count[i]++;
                    }
                }
            }
        }

        Arrays.sort(count);
        for (int i = 1; i <= cnt; i++) {
            System.out.println(count[i]);
        }
    }

    private static void dfs(int row, int col, int cnt) {

        visited[row][col] = true;
        map[row][col] = cnt;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) { //경계처리
                if (!visited[nr][nc] && map[nr][nc] == 1) {
                    dfs(nr, nc, cnt);
                }
            }
        }
    }
}