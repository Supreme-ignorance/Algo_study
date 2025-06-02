import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int K;
    static int LIMIT = 100_000;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        if (N >= K) {
            System.out.println(N - K);
        }
        else {
            visited = new boolean[LIMIT + 1];
            System.out.println(bfs());
        }
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.add(N);
        visited[N] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    return count;
                }

                if (0 <= current - 1 && !visited[current - 1]) {
                    queue.add(current - 1);
                    visited[current - 1] = true;
                }
                if (current + 1 <= LIMIT && !visited[current + 1]) {
                    queue.add(current + 1);
                    visited[current + 1] = true;
                }
                if (current * 2 <= LIMIT && !visited[current * 2]) {
                    queue.add(current * 2);
                    visited[current * 2] = true;
                }
            }
            count++;
        }
        return -1;
    }
}