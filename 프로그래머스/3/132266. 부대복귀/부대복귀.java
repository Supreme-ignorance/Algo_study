import java.util.*;

class Solution {
    
    List<Integer>[] adjList;
    int n;
    int[][] roads;
    int[] sources;
    int dest;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.n = n;
        this.roads = roads;
        this.sources = sources;
        this.dest = destination;
        
        adjList = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList();
        }  
        
        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];
            
            adjList[start].add(end);
            adjList[end].add(start);
        }
        
        // for (List list : adjList) {
        //     System.out.println(list);
        // }
        
        int[] answer = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            answer[i] = BFS(sources[i]);
        }
        
        return answer;
    }
    
    public int BFS(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        q.add(new int[]{start, 0});
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int[] curNode = q.poll();
            int cur = curNode[0];
            int count = curNode[1];
            
            if (cur == dest) {
                return count;
            }
            
            for (int next : adjList[cur]) {
                if (!visited[next]) {
                    q.add(new int[]{next, count + 1});
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}