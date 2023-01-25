import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K, count;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(count);



    }

    private static void dfs(int cr, int cc, int cnt) {
        if (cr == 0 && cc == C - 1) {
            if (cnt == K) {
                count++;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = cr + dr[d];
            int nc = cc + dc[d];
            if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc] && map[nr][nc] != 'T') {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1);
                visited[nr][nc] = false;
            }
        }


    }
}
