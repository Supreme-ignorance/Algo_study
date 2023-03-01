import java.util.*;

class Solution {
    
    private static final int MAX = Integer.MAX_VALUE; //270_000은 안되고 98765432는 왜 되지????
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        int[][] adjMatrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                adjMatrix[i][j] = (i == j) ? 0 : MAX;
            }
        }
        
        for (int i = 0; i < fares.length; i++) {
            int from = fares[i][0];
            int to = fares[i][1];
            int fare = fares[i][2];
            
            adjMatrix[from][to] = adjMatrix[to][from] = fare;
        } // 인접 행렬 초기화
        
        for (int wayPoint = 1; wayPoint <= n; wayPoint++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (adjMatrix[start][wayPoint] == MAX || adjMatrix[wayPoint][end] == MAX) {
                        continue;
                    }
                    if (adjMatrix[start][end] > adjMatrix[start][wayPoint] + adjMatrix[wayPoint][end]) {
                        adjMatrix[start][end] = adjMatrix[start][wayPoint] + adjMatrix[wayPoint][end];
                    }
                    // adjMatrix[start][end] = Math.min(adjMatrix[start][end], adjMatrix[start][wayPoint] + adjMatrix[wayPoint][end]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            int sum = adjMatrix[s][i] + adjMatrix[i][a] + adjMatrix[i][b];
            if (min > sum) {
                min = sum;
            }
        }
        
        // for (int i = 1; i <= n; i++) {
        //     if (adjMatrix[s][i] == MAX || adjMatrix[i][a] == MAX || adjMatrix[i][b] == MAX) {
        //         continue;
        //     }
        //     answer = Math.min(answer, adjMatrix[s][i] + adjMatrix[i][a] + adjMatrix[i][b]);
        // }
        int answer = min;
        return answer;
    }
    
    
}