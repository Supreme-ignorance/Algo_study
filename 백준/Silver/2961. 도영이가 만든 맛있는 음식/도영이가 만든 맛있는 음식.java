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

        recur(0, 1, 0, 0);
        System.out.println(min);

    }

    static void recur(int cur, int s, int b, int cnt) {
        // 기저조건
        if (cur == N) {
            if (cnt != 0) {
                min = Math.min(min, Math.abs(s - b));
            }
            return;
        }

        // 현재 것 사용하기
        recur(cur + 1, s * sour[cur], b + bitter[cur], cnt + 1);
        // 현재 것 안 뽑기
        recur(cur + 1, s, b, cnt);

    }
}
