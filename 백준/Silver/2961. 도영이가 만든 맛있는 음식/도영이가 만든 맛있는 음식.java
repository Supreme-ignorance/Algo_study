import java.util.Scanner;

public class Main {

    static int N;
    static int[] sour;
    static int[] bitter;

    static int[] selectedIndex;
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
            selectedIndex = new int[i];
            comb(0, 0, i);
        }

        System.out.println(min);

    }

    static void comb(int cur, int start, int limit) {
        // 기저조건
        if (cur == limit) {
            int s = 1;
            int b = 0;
            for (int i = 0; i < limit; i++) {
                s *= sour[selectedIndex[i]];
                b += bitter[selectedIndex[i]];
            }
            min = Math.min(min, Math.abs(s - b));
            return;
        }

        for (int i = start; i < N; i++) {
            selectedIndex[cur] = i;
            comb(cur + 1, i + 1, limit);
        }

    }
}
