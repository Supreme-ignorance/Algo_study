import java.util.Scanner;

public class Main {

    static int N, S;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        S = kb.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        recur(0, 0, 0);
        System.out.println(count);
    }

    static void recur(int cur, int total, int cnt) {
        // 기저조건
        if (cur == N) {
            if (total == S && cnt != 0) count++;
            return;
        }

        // 현재 것 뽑기
        recur(cur + 1, total + arr[cur], cnt + 1);
        // 현재 것 뽑지 않기
        recur(cur + 1, total, cnt);
    }
}
