import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int ROW;
    static int COL;
    static int K;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        ROW = Integer.parseInt(tokenizer.nextToken());
        COL = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        map = new int[ROW][COL];

        for (int r = 0; r < ROW; r++) {
            String line = br.readLine();
            for (int c = 0; c < COL; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }

        int[][][] visited = new int[K + 1][ROW][COL];
        for (int i = 0; i <= K; i++) {
            for (int r = 0; r < ROW; r++) {
                Arrays.fill(visited[i][r], Integer.MAX_VALUE);
            }
        }

        int result = -1;

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        pq.add(new Node(0, 0, K, 1));
        visited[K][0][0] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
//            System.out.println(cur);

            if (cur.row == ROW - 1 && cur.col == COL - 1) {
                result = cur.time;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nRow = cur.row + dr[d];
                int nCol = cur.col + dc[d];

                if (nRow < 0 || ROW <= nRow || nCol < 0 || COL <= nCol) continue; // 경계 처리
                if (map[nRow][nCol] == 1 && cur.blockCount != 0) {
                    if (cur.time + 1 < visited[cur.blockCount - 1][nRow][nCol]) {
                        visited[cur.blockCount - 1][nRow][nCol] = cur.time + 1;
                        pq.add(new Node(nRow, nCol, cur.blockCount - 1, cur.time + 1));
                    }
                }
                if (map[nRow][nCol] == 0) {
                    if (cur.time + 1 < visited[cur.blockCount][nRow][nCol]) {
                        visited[cur.blockCount][nRow][nCol] = cur.time + 1;
                        pq.add(new Node(nRow, nCol, cur.blockCount, cur.time + 1));
                    }
                }
            }
        }
        System.out.println(result);

    }

    static class Node {
        int row;
        int col;
        int blockCount;
        int time;

        Node (int r, int c, int bc, int t) {
            row = r;
            col = c;
            blockCount = bc;
            time = t;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    ", blockCount=" + blockCount +
                    ", time=" + time +
                    '}';
        }
    }
}