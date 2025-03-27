import java.util.*;

public class Main {

    static final int MAX = 100;

    static int[][] grid = new int[MAX][MAX];
    static boolean[][] outside;
    static int ROW;
    static int COL;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ROW = kb.nextInt();
        COL = kb.nextInt();

        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        int time = 0;
        while (true) {
            time++;
            // 외부 공기 초기화
            outside = new boolean[ROW][COL];
            // 맨 가장자리 4곳에서 BFS
            if (!outside[0][0]) {
                bfs(0, 0);
            }
            if (!outside[0][COL - 1]) {
                bfs(0, COL -1);
            }
            if (!outside[ROW - 1][0]) {
                bfs(ROW - 1, 0);
            }
            if (!outside[ROW - 1][COL - 1]) {
                bfs(ROW - 1, COL - 1);
            }

            List<int[]> meltingList = new ArrayList<>();
            for (int r = 0; r < ROW; r++) {
                for (int c = 0; c < COL; c++) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nextRow = r + dr[d];
                        int nextCol = c + dc[d];
                        if (inRange(nextRow, nextCol) && outside[nextRow][nextCol]) {
                            cnt++;
                        }
                    }
                    // 녹일 위치 체크
                    if (cnt >= 2) meltingList.add(new int[]{r, c});
                }
            }
            melting(meltingList);
            if (isDone()) {
                break;
            }
        }
        System.out.println(time);
    }

    static void bfs(int row, int col) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{row, col});
        outside[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextRow = curRow + dr[d];
                int nextCol = curCol + dc[d];
                if (inRange(nextRow, nextCol) && !outside[nextRow][nextCol] && grid[nextRow][nextCol] == 0) {
                    q.add(new int[]{nextRow, nextCol});
                    outside[nextRow][nextCol] = true;
                }
            }
        }
    }

    static boolean isDone() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (grid[r][c] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static void melting(List<int[]> meltingList) {
        for (int[] point : meltingList) {
            grid[point[0]][point[1]] = 0;
        }
    }

//    static void clearMelt() {
//        for (int r = 0; r < ROW; r++) {
//            for (int c = 0; c < COL; c++) {
//                outside[r][c] = false;
//            }
//        }
//    }

    static boolean inRange(int row, int col) {
        return 0 <= row && row < ROW && 0 <= col && col < COL;
    }
}
