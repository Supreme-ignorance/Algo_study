import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, L, R, X;
    static int[] arr;

    static int count = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        L = kb.nextInt();
        R = kb.nextInt();
        X = kb.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        recur(0, (int)1e9, (int)-1e9, 0, 0);

        System.out.println(count);
    }

    static void recur(int cnt, int min, int max, int sum, int c) {
        if (cnt == N) {
            if (c >= 2 && L <= sum && sum <= R && (max - min) >= X) {
                count++;
            }
            return;
        }

        recur(cnt + 1, Math.min(min, arr[cnt]), Math.max(max, arr[cnt]), sum + arr[cnt], c + 1);
        recur(cnt + 1, min, max, sum, c);
    }
}
