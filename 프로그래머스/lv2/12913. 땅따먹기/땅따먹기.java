import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int[][] memo = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            memo[0][i] = land[0][i];
        }
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    max = Math.max(max, memo[i - 1][k]);
                }
                memo[i][j] = max + land[i][j];
            }
        }
        
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, memo[land.length - 1][i]);
        }
        
        int answer = result;
        return answer;
    }
}