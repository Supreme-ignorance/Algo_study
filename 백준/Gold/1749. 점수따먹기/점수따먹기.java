import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] grid;
    static int[][] prefixSum;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        grid = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                grid[i][j] = kb.nextInt();
            }
        }

        prefixSum = new int[N + 1][M + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c - 1] - prefixSum[r - 1][c - 1] + grid[r][c];
            }
        }

//        for (int r = 1; r <= N; r++) {
//            for (int c = 1; c <= M; c++) {
//                System.out.printf("%4d ", prefixSum[r][c]);
//            }
//            System.out.println();
//        }

        int max = Integer.MIN_VALUE;
        // 어떻게 줄일 수 있을까?
        for (int r2 = 1; r2 <= N; r2++) {
            for (int c2 = 1; c2 <= M; c2++) {
                for (int r1 = 1; r1 <= r2; r1++) {
                    for (int c1 = 1; c1 <= c2; c1++) {
                        int result = prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1] + prefixSum[r1 - 1][c1 - 1];
                        max = Math.max(max, result);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
