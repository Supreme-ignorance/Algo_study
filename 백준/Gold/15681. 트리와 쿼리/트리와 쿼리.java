import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int ROOT;
    static int Q;

    static List<Integer>[] graph;
    static int[] subtreeSize;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        ROOT = kb.nextInt();
        Q = kb.nextInt();

        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            graph[s].add(e);
            graph[e].add(s);
        }

        // 기본적인 서브트리는 자신을 포함하여 1부터 시작
        subtreeSize = new int[N + 1];
        Arrays.fill(subtreeSize, 1);
        dfs(ROOT, ROOT);

        for (int q = 0; q < Q; q++) {
            System.out.println(subtreeSize[kb.nextInt()]);
        }
    }

    static void dfs(int cur, int prev) {

        for (int nxt : graph[cur]) {
            if (nxt == prev) continue;
            dfs(nxt, cur);
            subtreeSize[cur] += subtreeSize[nxt];
        }
    }

}
