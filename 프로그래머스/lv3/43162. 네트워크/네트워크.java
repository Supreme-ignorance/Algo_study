import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            bfs(i, computers);
            answer++;
        }
        return answer;
    }
    
    public static void bfs(int st, int[][] computers) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(st);
        visited[st] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int i = 0; i < computers[curr].length; i++) {
                if (computers[curr][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}