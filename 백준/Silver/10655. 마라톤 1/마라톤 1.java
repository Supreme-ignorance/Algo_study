import java.util.Scanner;

public class Main {

    static int N;
    static int[] rows;
    static int[] cols;

    static int[] dist;

    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        rows = new int[N];
        cols = new int[N];
        for (int i = 0; i < N; i++) {
            rows[i] = kb.nextInt();
            cols[i] = kb.nextInt();
        }
        dist = new int[N - 1];

        // N = 100_000
        int distSum = 0;
        for (int i = 0; i < N - 1; i++) {
            int curDist = Math.abs(rows[i] - rows[i + 1]) + Math.abs(cols[i] - cols[i + 1]);
            dist[i] = curDist;
            distSum += curDist;
        }
        // N = 100_000
        for (int i = 1; i < N - 1; i++) {
            int curSum = distSum - (dist[i] + dist[i - 1]);
            curSum += (Math.abs(rows[i - 1] - rows[i + 1]) + Math.abs(cols[i - 1] - cols[i + 1]));
            min = Math.min(min, curSum);
        }

        System.out.println(min);
    }
}
