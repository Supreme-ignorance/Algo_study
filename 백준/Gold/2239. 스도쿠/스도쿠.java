import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static int[][] grid = new int[9][9];
    static Set<Integer>[] rows = new Set[9];
    static Set<Integer>[] cols = new Set[9];
    static Set<Integer>[][] era = new Set[3][3];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int r = 0; r < 9; r++) {
            String line = kb.nextLine();
            for (int c = 0; c < 9; c++) {
                grid[r][c] = line.charAt(c) - '0';
            }
        }

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                era[i][j] = new HashSet<>();
            }
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (grid[r][c] != 0) rows[r].add(grid[r][c]);
            }
        }
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                if (grid[r][c] != 0) cols[c].add(grid[r][c]);
            }
        }
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (grid[r][c] != 0) {
                    int rowRest = r / 3;
                    int colRest = c / 3;

                    era[rowRest][colRest].add(grid[r][c]);
                }
            }
        }

        recur(0, 0);

    }

    static boolean recur(int row, int col) {
        if (col == 9) {
            row = row + 1;
            col = 0;
        }

        if (row == 9) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    System.out.print(grid[r][c]);
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }
        if (grid[row][col] != 0) {
            return recur(row, col + 1);
        }


        int rowRest = row / 3;
        int colRest = col / 3;
        for (int i = 1; i <= 9; i++) {
            if (rows[row].contains(i)) continue;
            if (cols[col].contains(i)) continue;
            if (era[rowRest][colRest].contains(i)) continue;

            // 선택
            rows[row].add(i);
            cols[col].add(i);
            era[rowRest][colRest].add(i);
            grid[row][col] = i;

            if (recur(row, col + 1)) return true;

            // 복구
            rows[row].remove(i);
            cols[col].remove(i);
            era[rowRest][colRest].remove(i);
            grid[row][col] = 0;
        }

        return false;
    }

}
