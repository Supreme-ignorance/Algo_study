import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int[] ROWS = {-1, 0, 1, 0};
    private static final int[] COLS = {0, 1, 0, -1};

    private static int[][] map;

    private static int R;
    private static int C;
    private static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        R = kb.nextInt();
        C = kb.nextInt();
        N = kb.nextInt();

        map = new int[R][C]; // 해당 int가 폭탄설치 시간
        for (int[] rows : map) {
            Arrays.fill(rows, -1); // -1은 null과 같다. 폭탄이 없는 곳
        }

        for (int row = 0; row < R; row++) {
            String line = kb.next();
            for (int col = 0; col < C; col++) {
                char next = line.charAt(col);
                if (next == '.') {
                    continue;
                } else { // 폭탄이면 0 넣기
                    map[row][col] = 0; // 0초에 폭탄 설치
                }
            }
        } //세팅 완료


        for (int currentSecond = 1; currentSecond <= N; currentSecond++) { //시간 초마다
            if (currentSecond % 2 == 0) {
                fillBombs(map, currentSecond);
            }
            checkMap(map, currentSecond);
        }

        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                sb.append(map[row][col] == -1 ? "." : "O"); // -1 즉 폭탄이 설치 안되어 있으면 ., 폭탄 있는 곳은 O
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void checkMap(int[][] map, int currentSecond) {
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                int time = currentSecond - map[row][col]; // 현재 시간과 폭탄 설치 시간의 시간차이
                if (time == 3 && map[row][col] != -1) { // 폭탄이 설치 된 곳이고, 시간이 3초차이 날 때
                    bang(row, col, map[row][col]);
                }
            }
        }
    }

    private static void bang(int row, int col, int firstBombSecond) {
        map[row][col] = -1;
        for (int d = 0; d < 4; d++) {
            int nextRow = row + ROWS[d];
            int nextCol = col + COLS[d];

            if (nextRow < 0 || R <= nextRow || nextCol < 0 || C <= nextCol) {
                continue; // 범위를 넘어가면 continue
            }
            if (map[nextRow][nextCol] > firstBombSecond) { //주변 폭탄 설치 시간이 해당 폭탄 시간보다 높으면 폭파
                map[nextRow][nextCol] = -1;
            }
        }
    }

    private static void fillBombs(int[][] map, int currentSecond) {

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (map[row][col] == -1) {
                    map[row][col] = currentSecond;
                }
            }
        }
    }

    static class Bomb {
        int installTime;

    }
}