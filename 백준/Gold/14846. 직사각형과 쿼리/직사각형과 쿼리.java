import java.util.Arrays;
import java.util.Scanner;

/**
 * O(M * N * N) 10_000 * 300 * 300
 */
public class Main {

    static int N;
    static int[][] grid;
    static int Q;

    static int[][][] prefixArr;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        grid = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        prefixArr = new int[N + 1][N + 1][11];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                int[] current = prefixArr[r][c];
                int number = grid[r][c];
                current[number]++;

                int[] beforeRow = prefixArr[r - 1][c];
                int[] beforeCol = prefixArr[r][c - 1];
                int[] duplicate = prefixArr[r - 1][c - 1];
                for (int i = 1; i <= 10; i++) {
                    current[i] += (beforeRow[i] + beforeCol[i] - duplicate[i]);
                }
            }
        }

//        for (int r = 1; r <= N; r++) {
//            for (int c = 1; c <= N; c++) {
//                System.out.println("r: " + r + " c: " + c);
//                System.out.println(Arrays.toString(prefixArr[r][c]));
//            }
//            System.out.println();
//        }


        Q = kb.nextInt();
        for (int q = 0; q < Q; q++) {
            int r1 = kb.nextInt();
            int c1 = kb.nextInt();
            int r2 = kb.nextInt();
            int c2 = kb.nextInt();

            int[] current = prefixArr[r2][c2];
            int[] beforeRow = prefixArr[r1 - 1][c2];
            int[] beforeCol = prefixArr[r2][c1 - 1];
            int[] duplicate = prefixArr[r1 - 1][c1 - 1];

            int cnt = 0;
            for (int i = 1; i <= 10; i++) {
                if(current[i] - beforeRow[i] - beforeCol[i] + duplicate[i] > 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}
