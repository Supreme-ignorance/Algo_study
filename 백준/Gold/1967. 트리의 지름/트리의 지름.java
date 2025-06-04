import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List<int[]>[] graph;
    static int[] dist;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            int s = kb.nextInt();
            int e = kb.nextInt();
            int d = kb.nextInt();

            graph[s].add(new int[]{e, d});
            graph[e].add(new int[]{s, d});
        }

        dist = new int[N + 1];
        // Tree는 모든 정점 쌍의 경로가 유일하니까 DFS 가능
        dfs(1, 1);

        int maxDist = 0;
        int maxNode = 1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                maxNode = i;
            }
        }

        dist = new int[N + 1];
        dfs(maxNode, maxNode);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dist[i]);
        }
        System.out.println(max);
    }

    static void dfs(int cur, int prev) {
        for (int[] nxt : graph[cur]) {
            int n = nxt[0];
            int d = nxt[1];
            if (n == prev) continue;
            dist[n] = dist[cur] + d;
            dfs(n, cur);
        }
    }

}
