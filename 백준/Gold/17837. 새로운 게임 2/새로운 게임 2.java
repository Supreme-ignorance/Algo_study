
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static final int WHITE = 0;
    static final int RED = 1;
    static final int BLUE = 2;

    static int N;
    static int K;
    static int time = 1;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static int[][] grid;
    static List<Integer>[][] locations;
    static List<Marker> markers;

    static boolean inRange(int row, int col) {
        return 0 <= row && row < N && 0 <= col && col < N;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        grid = new int[N][N];
        locations = new ArrayList[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                locations[r][c] = new ArrayList<>();
            }
        }

        markers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            int r = kb.nextInt() - 1;
            int c = kb.nextInt() - 1;
            int dir = kb.nextInt() - 1;

            markers.add(new Marker(i, r, c, dir));
            locations[r][c].add(i);
        }

//        print();
//        System.out.println();

        outer:
        for (time = 1; time <= 1000; time++) {

            for (int i = 0; i < markers.size(); i++) {
                Marker marker = markers.get(i);
                int curRow = marker.row;
                int curCol = marker.col;
                int curDir = marker.dir;

                List<Integer> list = locations[curRow][curCol];
                int targetIdx = list.indexOf(i);
                List<Integer> before = list.subList(0, targetIdx).stream().collect(Collectors.toList());
                List<Integer> after = list.subList(targetIdx, list.size()).stream().collect(Collectors.toList());

                // 방향으로 이동
                int nextRow = curRow + dr[curDir];
                int nextCol = curCol + dc[curDir];
                // 범위 밖이거나 만약 파랑이면
                if (!inRange(nextRow, nextCol) || grid[nextRow][nextCol] == BLUE) {
                    int oppositeDir = changeDir(curDir);
                    marker.dir = oppositeDir;
                    int opRow = curRow + dr[oppositeDir];
                    int opCol = curCol + dc[oppositeDir];
                    // 범위 안인데
                    if (inRange(opRow, opCol)) {
                        if (grid[opRow][opCol] == WHITE) {
                            goToWhite(opRow, opCol, after);
                            locations[curRow][curCol] = before;
                            if (isOver(opRow, opCol)) break outer;
                        }
                        if (grid[opRow][opCol] == RED) {
                            goToRed(opRow, opCol, after);
                            locations[curRow][curCol] = before;
                            if (isOver(opRow, opCol)) break outer;
                        }
                        if (grid[opRow][opCol] == BLUE) continue;
                    }
                    if (!inRange(opRow, opCol)) continue;
                }
                // 만약 흰색이면 위에 쌓인 것 그대로 가져간다.
                if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] == WHITE) {
                    goToWhite(nextRow, nextCol, after);
                    locations[curRow][curCol] = before;
                    if (isOver(nextRow, nextCol)) break outer;
                }
                // 빨간색이면 위에 쌓인 것과 반대로 가져간다.
                if (inRange(nextRow, nextCol) && grid[nextRow][nextCol] == RED) {
                    goToRed(nextRow, nextCol, after);
                    locations[curRow][curCol] = before;
                    if (isOver(nextRow, nextCol)) break outer;
                }

            }
//            print();
//            System.out.println();
        }
        System.out.println(time > 1000 ? -1 : time);
    }

    static boolean isOver(int row, int col) {
        return locations[row][col].size() >= 4;
    }

    static void goToWhite(int nextRow, int nextCol, List<Integer> after) {
        for (int j = 0; j < after.size(); j++) {
            int idx = after.get(j);
            locations[nextRow][nextCol].add(idx);
            Marker target = markers.get(idx);
            target.row = nextRow;
            target.col = nextCol;
        }
    }
    static void goToRed(int nextRow, int nextCol, List<Integer> after) {
        for (int j = after.size() - 1; j >= 0; j--) {
            int idx = after.get(j);
            locations[nextRow][nextCol].add(idx);
            Marker target = markers.get(idx);
            target.row = nextRow;
            target.col = nextCol;
        }
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(locations[r][c] + "\t");
            }
            System.out.println();
        }

    }

    static int changeDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        if (dir == 3) return 2;
        return -1;
    }

    static class Marker {
        int idx;
        int row;
        int col;
        int dir;
        Marker(int i, int r, int c, int d) {
            idx = i;
            row = r;
            col = c;
            dir = d;
        }
    }
}
