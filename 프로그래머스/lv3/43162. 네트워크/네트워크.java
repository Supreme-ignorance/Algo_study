import java.util.*;

class Solution {
    
    private int[] visited;
    
    public int solution(int n, int[][] computers) {
        
        visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, computers, n, count);
            }
        }
        
        int answer = count;
        return answer;
    }
    
    private void dfs(int index, int[][] computers, int n, int count) {
        
        visited[index] = count;
        
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0 && computers[index][i] == 1) {
                dfs(i, computers, n, count);
            }
        }
    }
}