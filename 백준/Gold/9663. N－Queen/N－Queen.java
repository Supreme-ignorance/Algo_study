import java.util.Scanner;

public class Main {

    static int N;
    static int sum;
    static boolean[] col, d1, d2;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        col = new boolean[N];
        d1 = new boolean[2 * N - 1];
        d2 = new boolean[2 * N - 1];

        recur(0);
        System.out.println(sum);
    }

    static void recur(int r) {
        if (r == N) {
            sum++;
            return;
        }
        for (int c = 0; c < N; c++) {
            int p = r - c + N - 1;
            int q = r + c;
            if (col[c] || d1[p] || d2[q]) continue;
            col[c] = d1[p] = d2[q] = true;
            recur(r + 1);
            col[c] = d1[p] = d2[q] = false;
        }
    }
}
