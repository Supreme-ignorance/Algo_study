import java.util.*;

public class Main {
    static final int MAX = 100_000;

    static int N;
    static int K;
    static boolean[] visited = new boolean[MAX + 1];
    static int[] dist = new int[MAX + 1];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                System.out.println(dist[cur]);
                break;
            }

            if (inRange(cur + 1) && !visited[cur + 1]) {
                q.add(cur + 1);
                visited[cur + 1] = true;
                dist[cur + 1] = dist[cur] + 1;
             }
            if (inRange(cur - 1) && !visited[cur - 1]) {
                q.add(cur - 1);
                visited[cur - 1] = true;
                dist[cur - 1] = dist[cur] + 1;
            }
            if (inRange(cur * 2) && !visited[cur * 2]) {
                q.add(cur * 2);
                visited[cur * 2] = true;
                dist[cur * 2] = dist[cur] + 1;
            }

        }
    }

    static boolean inRange(int i) {
        return 0 <= i && i <= MAX;
    }
}
