import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static List[] graph;
    static int[] parent;

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
            graph[s].add(e);
            graph[e].add(s);
        }

        parent = new int[N + 1];
        dfs(1, 1);
        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int cur, int prev) {

        List<Integer> curList = graph[cur];
        for (int nxt : curList) {
            if (nxt == prev) continue;
            parent[nxt] = cur;
            dfs(nxt, cur);
        }
    }
}
