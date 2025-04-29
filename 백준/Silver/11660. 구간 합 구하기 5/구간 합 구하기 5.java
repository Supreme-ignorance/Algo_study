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

        grid = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        prefixSum = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                prefixSum[r][c] = prefixSum[r - 1][c] + prefixSum[r][c - 1] - prefixSum[r - 1][c - 1] + grid[r][c];
            }
        }

//        for (int r = 1; r <= N; r++) {
//            for (int c = 1; c <= N; c++) {
//                System.out.print(prefixSum[r][c] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 0; i < M; i++) {
            int r1 = kb.nextInt();
            int c1 = kb.nextInt();
            int r2 = kb.nextInt();
            int c2 = kb.nextInt();

            int result = prefixSum[r2][c2] - prefixSum[r1 - 1][c2] - prefixSum[r2][c1 - 1] + prefixSum[r1 - 1][c1 - 1];
            System.out.println(result);
        }
    }
}
