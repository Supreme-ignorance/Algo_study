import java.util.*;

public class Main {
    static final int INF = (int) 1e9;
    static final int MAX_N = 50_000;
    static List<Node>[] graph = new List[MAX_N + 1];
    static int[] dist = new int[MAX_N + 1];

    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = kb.nextInt();
            int end = kb.nextInt();
            int dist = kb.nextInt();

            graph[start].add(new Node(end, dist));
            graph[end].add(new Node(start, dist));
        }

        dijk(1);
        System.out.println(dist[N]);
    }

    static void dijk(int start) {
        Arrays.fill(dist, 1, N + 1, INF);
        dist[start] = 0;
        Queue<Element> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new Element(start, 0));

        while (!pq.isEmpty()) {
            Element cur = pq.poll();
            int curIdx = cur.idx;
            int curDist = cur.dist;

            if (dist[curIdx] < curDist) continue;

            List<Node> ways = graph[curIdx];
            for (int i = 0; i < ways.size(); i++) {
                Node next = ways.get(i);

                int newDist = dist[curIdx] + next.dist;
                if (dist[next.idx] > newDist) {
                    pq.add(new Element(next.idx, newDist));
                    dist[next.idx] = newDist;
                }
            }
        }
    }

    static class Node {
        int idx;
        int dist;
        Node(int i, int d) {
            idx = i;
            dist = d;
        }
    }
    static class Element {
        int idx;
        int dist;
        Element(int i, int d) {
            idx = i;
            dist = d;
        }

    }
}
