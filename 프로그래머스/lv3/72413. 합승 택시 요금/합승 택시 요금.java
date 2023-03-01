import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int to;
        int weight;
        
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static List<Node>[] adjList;
    static boolean[] visited;
    static int minCharge;
    static int N;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new ArrayList[n + 1];
        
        for(int i = 0; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < fares.length; i++) {
            int st = fares[i][0];
            int ed = fares[i][1];
            int weight = fares[i][2];
            
            adjList[st].add(new Node(ed, weight));
            adjList[ed].add(new Node(st, weight));
        }
        
        minCharge = Integer.MAX_VALUE;
        
        // s, a, b를 시작점으로 하여 모든 점까지 최단거리를 각각 구해놓기
        visited = new boolean[n + 1];
        int[] distS = dijkstra(s, new int[n + 1]);
        
        visited = new boolean[n + 1];
        int[] distA = dijkstra(a, new int[n + 1]);
        
        visited = new boolean[n + 1];
        int[] distB = dijkstra(b, new int[n + 1]);
        
        for (int d = 1; d <= n; d++) {
            minCharge = Math.min(minCharge, distS[d] + distA[d] + distB[d]);
        }
        
        int answer = minCharge;
        return answer;
    }
    
    public int[] dijkstra(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.to]) {
                continue;
            }
            visited[curr.to] = true;
            for (Node node : adjList[curr.to]) {
                if (!visited[node.to] && dist[node.to] >  dist[curr.to] + node.weight) {
                    dist[node.to] = dist[curr.to] + node.weight;
                    pq.add(new Node(node.to, dist[node.to]));
                }
            }
        }
        
        return dist;
    }
}