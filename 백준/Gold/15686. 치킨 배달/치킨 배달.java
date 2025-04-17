import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dr = {-1, 0, 1, 0}; //상 우 하 좌
    private static int[] dc = {0, 1, 0, -1};
    private static int[][] map;
    private static List<Node> homes;
    private static List<Node> chickens;

    private static int N;
    private static int M;

    private static int finalMin = Integer.MAX_VALUE;

    private static Node[] output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.valueOf(tokenizer.nextToken()); // N 개의 줄
        M = Integer.valueOf(tokenizer.nextToken()); // 최대 폐업 치킨 수

        homes = new ArrayList<>();
        chickens = new ArrayList<>();
        output = new Node[M];

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            tokenizer = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                int value = Integer.valueOf(tokenizer.nextToken());
                if (value == 1) {
                    homes.add(new Node(r, c));
                }
                if (value == 2) {
                    chickens.add(new Node(r, c));
                }
                map[r][c] = value;
            }
        }
        //세팅

        comb(0, 0);
        System.out.println(finalMin);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {
            int min = 0;
            for (Node home : homes) {
                int minDistance = getDistance(home, output);
                min += minDistance;
            }
            if (finalMin > min) {
                finalMin = min;
            }
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            Node target = chickens.get(i);
            output[cnt] = target;
            comb(cnt + 1, i + 1);
        }
    }

    private static int getDistance(Node home, Node[] output) {
        int min = Integer.MAX_VALUE;
        for (Node chicken : output) {
            int distance = Math.abs(home.row - chicken.row) + Math.abs(home.col - chicken.col);
            if (min > distance) {
                min = distance;
            }
        }
        return min;
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }
}