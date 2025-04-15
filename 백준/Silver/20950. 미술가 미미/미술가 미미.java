import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] RGB;
    static int[] target = new int[3];

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        RGB = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer t = new StringTokenizer(br.readLine(), " ");
            RGB[i][0] = Integer.parseInt(t.nextToken());
            RGB[i][1] = Integer.parseInt(t.nextToken());
            RGB[i][2] = Integer.parseInt(t.nextToken());
        }
        StringTokenizer t = new StringTokenizer(br.readLine(), " ");
        target[0] = Integer.parseInt(t.nextToken());
        target[1] = Integer.parseInt(t.nextToken());
        target[2] = Integer.parseInt(t.nextToken());

        recur(0, 0, 0, 0, 0);
        System.out.println(min);
    }

    static void isMin(int red, int green, int blue) {
        int current = Math.abs(red - target[0]) + Math.abs(green - target[1]) + Math.abs(blue - target[2]);
        min = Math.min(min, current);
    }

    static void recur(int cur, int r, int g, int b, int count) {
        // 기저 조건
        if (cur == N) {
            if (count != 0 && count != 1 && count <= 7) {
                int red = r / count;
                int green = g / count;
                int blue = b / count;
                isMin(red, green, blue);
            }
            return;
        }

        if (count > 7) {
            return;
        }

        // 현재 물감 사용하기
        recur(cur + 1, r + RGB[cur][0], g + RGB[cur][1], b + RGB[cur][2], count + 1);
        // 현재 물감 사용 안하기
        recur(cur + 1, r, g, b, count);
    }
}
