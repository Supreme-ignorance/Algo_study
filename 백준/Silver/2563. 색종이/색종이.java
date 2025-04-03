import java.util.Scanner;

public class Main {

    static final int MAX_N = 100;

    static int[][] grid = new int[100][100];

    static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            int col = kb.nextInt();
            int row = kb.nextInt();
            paint(row, col);
        }

        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                cnt += grid[i][j];
            }
        }
        System.out.println(cnt);
    }

    static void paint(int row, int col) {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                grid[row + r][col + c] = 1;
            }
        }
    }
}
