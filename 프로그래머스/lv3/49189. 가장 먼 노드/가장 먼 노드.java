import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] adjList = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int start = e[0];
            int end = e[1];
            
            adjList[start].add(end);
            adjList[end].add(start);
        }
        
        //방문 처리용 1차원 배열
        boolean[] visited = new boolean[n + 1];
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
        int count = 0;
        int max = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int idx = current[0];
            int distance = current[1];
            
            if (max == distance) { //최대 거리와 같으면, 카운트 더하기
                count++;
            }
            if (max < distance) { //최대 거리가 바뀌면, count 초기화 및 max 갱신
                count = 1;
                max = distance;
            }
            
            for (int nextIdx : adjList[idx]) {
                if (!visited[nextIdx]) {
                    queue.add(new int[]{nextIdx, distance + 1});
                    visited[nextIdx] = true;
                }
            }
        }
        
        int answer = count;
        return answer;
    }
    
}