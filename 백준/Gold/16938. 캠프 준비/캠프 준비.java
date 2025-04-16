import java.util.Scanner;

public class Main {

    static int N, L, R, X;
    static int[] arr;

    static int total = 0;

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
        recur(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(total);
    }

    static void recur(int cur, int cnt, int sum, int min, int max) {
        // 기저조건
        if (cur == N) {
            if (cnt >= 2) {
                // L과 R 사이, 최댓값 최솟값의 차이가 X 이상
                if (L <= sum && sum <= R && X <= max - min) {
                    total++;
                }
            }
            return;
        }

        // 현재 것 뽑기
        recur(cur + 1, cnt + 1, sum + arr[cur], Math.min(min, arr[cur]), Math.max(max, arr[cur]));
        // 현재 것 안 뽑기
        recur(cur + 1, cnt, sum, min, max);
    }
}
