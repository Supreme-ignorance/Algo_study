import java.util.Scanner;

public class Main {

    static int N;
    static int START;
    static int END;
    static int M;
    static int[][] graph;
    static boolean[] visited;

    static int count = -1;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        START = kb.nextInt();
        END = kb.nextInt();

        M = kb.nextInt();

        graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();

            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        visited = new boolean[N + 1];
        dfs(START, 0);
        System.out.println(count);
    }

    static void dfs(int curIdx, int cnt) {
        if (curIdx == END) {
            count = cnt;
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            if (graph[curIdx][i] == 1) {
                visited[i] = true;
                dfs(i, cnt + 1);
            }
        }
    }
}
