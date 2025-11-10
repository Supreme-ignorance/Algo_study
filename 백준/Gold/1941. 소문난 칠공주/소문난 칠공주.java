import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static char[][] grid = new char[5][5];
    static boolean[][] chosen = new boolean[5][5];
    static int answer = 0;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int r = 0; r < 5; r++) {
            String line = kb.nextLine();
            for (int c = 0; c < 5; c++) {
                grid[r][c] = line.charAt(c);
            }
        }

        recur(0, 0, 0, 0);
        System.out.println(answer);
    }

    static void recur(int picked, int row, int col, int yCount) {
        // 7개를 뽑았으면 확인해보자
        if (picked == 7) {
            if (yCount <= 3 && isConnected()) answer++;
            return;
        }

        // 5가 되면 row 값을 하나 더 올려주고 col을 0으로
        if (col == 5) {
            row = row + 1;
            col = 0;
        }
        // row가 5가 되는 순간 더 볼필요가 없음
        if (row == 5) {
            return;
        }
        // Y가 4개 이상되면 S가 4개 이상이 될 수 없으므로 더 볼 필요 없음
        if (yCount >= 4) {
            return;
        }


        // 현재 칸 선택
        chosen[row][col] = true;
        recur(picked + 1, row, col + 1, yCount + (grid[row][col] == 'Y' ? 1 : 0));
        chosen[row][col] = false;

        // 현재 칸 미선택
        recur(picked, row, col + 1, yCount);
    }

    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new ArrayDeque<>();

        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (chosen[i][j]) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    break outer;
                }
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || 5 <= nr || nc < 0 || 5 <= nc) continue;
                if (visited[nr][nc]) continue;
                if (!chosen[nr][nc]) continue;

                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
            }
        }

        return count == 7;
    }
}
