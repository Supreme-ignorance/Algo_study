import java.util.Scanner;

public class Main {
    static int M, N;
    static int[] growth;
    // 왼쪽, 왼쪽 위, 위
    static int[] dr = {0, -1, -1};
    static int[] dc = {-1, -1, 0};
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][M];
        growth = new int[3];

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = 1;
            }
        }

        for (int d = 0; d < N; d++) {
            // 0의 개수
            growth[0] = sc.nextInt();
            // 1의 개수
            growth[1] = sc.nextInt();
            // 2의 개수
            growth[2] = sc.nextInt();

            // 가장자리 업데이트
            outlineGrowth();
            // 내부 업데이트
            innerGrowth();
        }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }

    }

    private static void innerGrowth() {
        for (int r = 1; r < M; r++) {
            for (int c = 1; c < M; c++) {
                map[r][c] = Math.max(map[r + dr[0]][c + dc[1]], Math.max(map[r + dr[1]][c + dc[1]], map[r + dr[2]][c + dc[2]]));
            }
        }

    }

    private static void outlineGrowth() {
        int cr = M - 1;
        int cc = 0;
        boolean upperLine = false;

        // 0 만큼 성장
        for (int z = 0; z < growth[0]; z++) {
            if (!upperLine) {
                cr--;
                if (cr == 0) {
                    upperLine = true;
                    continue;
                }
            }
            if (upperLine)
                cc++;
        }

        // 1 만큼 성장
        for (int o = 0; o < growth[1]; o++) {
            map[cr][cc] += 1;
            if (!upperLine) {
                cr--;
                if (cr == 0) {
                    upperLine = true;
                    continue;
                }
            }
            if (upperLine)
                cc++;
        }

        // 2 만큼 성장
        for (int t = 0; t < growth[2]; t++) {
            map[cr][cc] += 2;
            if (!upperLine) {
                cr--;
                if (cr == 0) {
                    upperLine = true;
                    continue;
                }
            }
            if (upperLine)
                cc++;
        }



    }
}
