import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static final int[] ROWS = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] COLUMNS = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int N;

    public static int M;

    private static int[][] space;

    private static int[][] visited;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        space = new int[N][M];
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {
                space[row][column] = kb.nextInt();
            }
        }
        //map 세팅 완료
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < M; column++) {

                if (space[row][column] == 1) { //상어가 있는 곳이면 스킵하자 -> 어차피 안전거리 0

                    bfs(row, column);
                }
            }
        }

        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (visited[r][c] > max) {
                    max = visited[r][c];
                }
            }
        }

        System.out.println(max);
    }

    private static void bfs(int row, int column) {
        int range = 0; // 거리
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        rowQueue.offer(row);
        colQueue.offer(column);
        visited[row][column] = range;

        while (!rowQueue.isEmpty()) {
            int size = rowQueue.size();
            range++;

            while (--size >= 0) {
                Integer r = rowQueue.poll();
                Integer c = colQueue.poll();

                for (int d = 0; d < 8; d++) {
                    int nextRow = r + ROWS[d];
                    int nextColumn = c + COLUMNS[d];

                    if (nextRow < 0 || N <= nextRow || nextColumn < 0 || M <= nextColumn) { // 배열의 크기만큼 검증
                        continue;
                    }

                    if (visited[nextRow][nextColumn] > range || visited[nextRow][nextColumn] == -1) {
                        visited[nextRow][nextColumn] = range;
                        rowQueue.add(nextRow);
                        colQueue.add(nextColumn);
                    }

                }
            }
//            print();
        }
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}