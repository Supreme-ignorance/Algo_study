import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] result;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        result = new int[M];

        recur(0, 1);
    }

    static void recur(int cnt, int start) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            result[cnt] = i;
            recur(cnt + 1, i + 1);
        }
    }
}
