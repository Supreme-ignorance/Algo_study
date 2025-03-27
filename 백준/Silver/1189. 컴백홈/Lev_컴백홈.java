import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};

    private static char[][] map;
    private static int R;
    private static int C;
    private static int K;

    private static int result = 0;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String stringLine = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = stringLine.charAt(c);
            }
        }

        dfs(R - 1, 0, 0);

        System.out.println(result);
    }

    private static void dfs(int row, int col, int lengthCount) {
        visited[row][col] = true;
        lengthCount++;

        //기저조건
        if (row == 0 && col == C - 1 && lengthCount == K) {
            result++;
            settingToBefore(row, col);
            return;
        }


        if (lengthCount > K) { // K보다 많으면 더이상 살펴볼 이유가 없으므로 return
            settingToBefore(row, col);
            return;
        }

        for (int d = 0; d < 4; d++) {
           int nextRow = row + dr[d];
           int nextCol = col + dc[d];

           if (0 <= nextRow && nextRow < R && 0 <= nextCol && nextCol < C && !visited[nextRow][nextCol] && map[nextRow][nextCol] != 'T') {
               //경계처리 및 아직 방문하지 않았다면 + T가 아니라면
                dfs(nextRow, nextCol, lengthCount);
           }
        }
        settingToBefore(row, col);
    }

    private static void settingToBefore(int row, int col) {
        visited[row][col] = false;
    }
}