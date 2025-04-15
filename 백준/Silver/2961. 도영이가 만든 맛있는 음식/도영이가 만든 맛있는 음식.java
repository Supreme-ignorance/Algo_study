import java.util.Scanner;

public class Main {

    static int N;
    static int[] sour;
    static int[] bitter;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            sour[i] = kb.nextInt();
            bitter[i] = kb.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            comb(0, 0, 1, 0, i);
        }

        System.out.println(min);

    }

    static void comb(int cur, int start, int s, int b, int limit) {
        // 기저조건
        if (cur == limit) {
            min = Math.min(min, Math.abs(s - b));
            return;
        }

        for (int i = start; i < N; i++) {
            comb(cur + 1, i + 1, s * sour[i], b + bitter[i], limit);
        }

    }
}
