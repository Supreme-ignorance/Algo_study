import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int year = 0;
    static ArrayDeque<Glacier> glaciers = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Glacier[][] map = new Glacier[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = new Glacier(i, j, h);
                if (h > 0) {
                    glaciers.add(map[i][j]);
                }
            }
        }

        label:
        while (true) {
            year++;
            setMelt(map);
            melt();
            if (glaciers.isEmpty()) {
                System.out.println(0);
                return;
            }
            if (!checkConn(glaciers.peek().x, glaciers.peek().y, map, new boolean[map.length][map[0].length])) {
                break label;
            }
        }

        System.out.println(year);
    }


    private static boolean checkConn(int x, int y, Glacier[][] map, boolean[][] visited) {
        dfs(x, y, map, visited);
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                if (map[i][j].height > 0 && !visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void dfs(int x, int y, Glacier[][] map, boolean[][] visited) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            if (map[nX][nY].height > 0 && !visited[nX][nY]) {
                dfs(nX, nY, map, visited);
            }
        }
    }

    private static void setMelt(Glacier[][] map) {
        Iterator<Glacier> iterator = glaciers.iterator();
        while (iterator.hasNext()) {
            Glacier cur = iterator.next();
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nX = cur.x + dx[i];
                int nY = cur.y + dy[i];
                if (map[nX][nY].height <= 0) {
                    cnt++;
                }
            }
            cur.melt = cnt;
        }
    }

    private static void melt() {
        Iterator<Glacier> iterator = glaciers.iterator();
        while (iterator.hasNext()) {
            Glacier cur = iterator.next();
            cur.melt();
            if (cur.height <= 0) {
                iterator.remove();
            }
        }
    }

    static class Glacier {

        int x;
        int y;
        int height;
        int melt;

        public Glacier(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        public void melt() {
            this.height -= melt;
        }
    }
}
