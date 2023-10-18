import java.util.*;

class Solution {
    
    int[][] adjMatrix;
    int n;
    int min;
    
    public int solution(int n, int[][] wires) {
        
        this.n = n;
        
        adjMatrix = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            int start = wires[i][0];
            int end = wires[i][1];
            
            adjMatrix[start][end] = adjMatrix[end][start] = 1;
        }
        
        min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (adjMatrix[i][j] != 0) {
                    adjMatrix[i][j] = adjMatrix[j][i] = 0;
                    cal();
                    adjMatrix[i][j] = adjMatrix[j][i] = 1;
                }
            }
        }
        
        int answer = min;
        return answer;
    }
    
    private void cal() {
        int[] visited = new int[n + 1];
        
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                bfs(i, visited, count);
                count++;
            }
        }
        int one = 0;
        int two = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 1) {
                one++;
            }
            else {
                two++;
            }
        }
        
        int result = Math.abs(one - two);
        if (min > result) {
            min = result;
        }
    }
    
    private void bfs(int startIndex, int[] visited, int count) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startIndex);
        visited[startIndex] = count;
        
        while(!q.isEmpty()) {
            int current = q.poll();
            for (int i = 1; i <= n; i++) {
                if (adjMatrix[current][i] == 1 && visited[i] == 0) { //연결되어있고, 아직 방문하지 않았다면
                    q.add(i);
                    visited[i] = count;
                }
            }
        }
    }
    
    private void printMatrix() {
        for (int[] ints : adjMatrix) {
            for (int aInt : ints) {
                System.out.print(aInt + " ");
            }
            System.out.println();
        }
    }
}