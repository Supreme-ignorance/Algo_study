import java.util.Scanner;

/** 중복 없는 수열 */
public class Main {
    static final int MAX_N = 8;
    static int N, M;

    static boolean[] visited = new boolean[MAX_N + 1];
    static int[] selected = new int[MAX_N + 1];


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        recur(0, 0);
    }

    static void recur(int curIdx, int total) {
        if (total == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            selected[curIdx] = i;
            visited[i] = true;
            recur(curIdx + 1, total + 1);
            visited[i] = false;
        }

    }
}
