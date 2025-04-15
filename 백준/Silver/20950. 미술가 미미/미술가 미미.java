import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] RGB;
    static int[] target = new int[3];

    static int min = Integer.MAX_VALUE;
//    static int[] selected;

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

        for (int i = 2; i <= 7; i++) {
//            selected = new int[i];
            comb(0, 0, 0, 0, 0, i);
        }
        System.out.println(min);
    }

    static int isMin(int red, int green, int blue) {
        int current = Math.abs(red - target[0]) + Math.abs(green - target[1]) + Math.abs(blue - target[2]);
        min = Math.min(min, current);
        return current;
    }

    static void comb(int cur, int start, int r, int g, int b, int limit) {
        // 기저 조건
        if (cur >= limit) {
//            System.out.println(Arrays.toString(selected));
            int red = r / limit;
            int green = g / limit;
            int blue = b / limit;
            isMin(red, green, blue);
            return;
        }

        for (int i = start; i < N; i++) {
            comb(cur + 1, i + 1, r + RGB[i][0], g + RGB[i][1], b + RGB[i][2], limit);
        }
    }
}
