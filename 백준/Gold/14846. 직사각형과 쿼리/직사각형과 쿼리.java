import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] grid;
    static int Q;

    static int[][][] prefixArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N + 1][N + 1];
        for (int r = 1; r <= N; r++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int c = 1; c <= N; c++) {
                grid[r][c] = Integer.parseInt(tokenizer.nextToken());
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


        Q = Integer.parseInt(br.readLine());
        for (int q = 0; q < Q; q++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int r1 = Integer.parseInt(tokenizer.nextToken());
            int c1 = Integer.parseInt(tokenizer.nextToken());
            int r2 = Integer.parseInt(tokenizer.nextToken());
            int c2 = Integer.parseInt(tokenizer.nextToken());

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
