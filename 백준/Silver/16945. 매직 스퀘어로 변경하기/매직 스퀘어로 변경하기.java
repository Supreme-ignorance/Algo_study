import java.util.Scanner;

public class Main {

    static int[][] grid = new int[3][3];
    static int[][] arr = new int[3][3];
    static boolean[] visited = new boolean[10];

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                grid[r][c] = kb.nextInt();
            }
        }

        recur(0, 0);
        System.out.println(min);
    }

    static void recur(int row, int col) {
        if (row == 3) {
            if (isMagic()) {
                int sum = 0;
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        sum += Math.abs(grid[r][c] - arr[r][c]);
                    }
                }
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            arr[row][col] = i;
            if (col + 1 == 3) {
                recur(row + 1, 0);
            }
            else {
                recur(row, col + 1);
            }
            visited[i] = false;
        }
    }

    static boolean isMagic() {
        int org = arr[0][0] + arr[0][1] + arr[0][2];
        for (int r = 0; r < 3; r++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += arr[r][i];
            }
            if (sum != org) return false;
        }

        for (int c = 0; c < 3; c++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += arr[i][c];
            }
            if (sum != org) return false;
        }

        int d1 = 0;
        int d2 = 0;
        for (int i = 0; i < 3; i++) {
            d1 += arr[i][i];
            d2 += arr[2 - i][i];
        }
        if (d1 != org) return false;
        if (d2 != org) return false;

        return true;
    }
}
