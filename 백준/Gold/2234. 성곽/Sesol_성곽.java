import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Byte.parseByte(st.nextToken());
        int m = Byte.parseByte(st.nextToken());

        int roomCnt = 0;
        int maxWidth = 0;
        int maxSum = 0;

        int[][] map = new int[m][n];
        int[][] roomMap = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Map<Integer, Integer> roomWidth = new HashMap<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int width = bfs(map, i, j, roomCnt, visited, roomMap);
                    roomWidth.put(roomCnt++, width);
                    maxWidth = Math.max(maxWidth, width);
                }
            }
        }

        visited = new boolean[m][n];
        maxSum = findMaxSum(roomMap, roomWidth, visited);

        System.out.println(roomCnt);
        System.out.println(maxWidth);
        System.out.println(maxSum);

    }

    private static int findMaxSum(int[][] roomMap, Map<Integer, Integer> roomWidth,
        boolean[][] visited) {
        int width = 0;
        Queue<Location> q = new ArrayDeque<>();
        q.offer(new Location(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Location cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dx[k];
                int nY = cur.y + dy[k];
                if (nX >= 0 && nX < roomMap.length && nY >= 0 && nY < roomMap[0].length
                    && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    if (roomMap[cur.x][cur.y] == roomMap[nX][nY]) {
                        q.offer(new Location(nX, nY));

                    } else {
                        width = Math.max(width,
                            roomWidth.get(roomMap[nX][nY]) + roomWidth.get(roomMap[cur.x][cur.y]));
                        q.offer(new Location(nX, nY));
                    }
                }
            }

        }

        return width;
    }

    private static int bfs(int[][] map, int i, int j, int roomCnt, boolean[][] visited,
        int[][] roomMap) {
        int width = 0;
        Queue<Location> q = new ArrayDeque<>();
        q.offer(new Location(i, j));
        roomMap[i][j] = roomCnt;
        visited[i][j] = true;
        while (!q.isEmpty()) {
            Location cur = q.poll();
            roomMap[cur.x][cur.y] = roomCnt;
            width++;
            for (int k = 0; k < 4; k++) {
                if (((1 << k) & map[cur.x][cur.y]) == 0) {
                    int nX = cur.x + dx[k];
                    int nY = cur.y + dy[k];
                    if (!visited[nX][nY]) {
                        visited[nX][nY] = true;
                        q.offer(new Location(nX, nY));
                    }
                }
            }

        }

        return width;
    }

    private static class Location {

        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}