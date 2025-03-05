import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 100_000;
    static final int LIMIT = MAX_N + 1;
    static int[] dist = new int[MAX_N + 1];

    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        Arrays.fill(dist, LIMIT);

        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new Node(N, 0));
        dist[N] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 갱신되었으면 dist 제외
            if (dist[cur.idx] < cur.time) continue;
            
            if (cur.idx == K) {
                break;
            }

            int teleportIdx = cur.idx * 2;
            if (inRange(teleportIdx) && dist[teleportIdx] > cur.time) {
                dist[teleportIdx] = cur.time;
                pq.add(new Node(teleportIdx, cur.time));
            }
            int nextIdx = cur.idx + 1;
            if (inRange(nextIdx) && dist[nextIdx] > cur.time + 1) {
                dist[nextIdx] = cur.time + 1;
                pq.add(new Node(nextIdx, cur.time + 1));
            }
            int beforeIdx = cur.idx - 1;
            if (inRange(beforeIdx) && dist[beforeIdx] > cur.time + 1) {
                dist[beforeIdx] = cur.time + 1;
                pq.add(new Node(beforeIdx, cur.time + 1));
            }
        }
        System.out.println(dist[K]);
    }

    static boolean inRange(int idx) {
        return 0 <= idx && idx <= MAX_N;
    }

    static class Node {
        int idx;
        int time;
        Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
