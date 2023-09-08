import java.util.*;

class Solution {
    
    public int solution(int x, int y, int n) {
        
        int[] memo = new int[1_000_000 + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (memo[i] != Integer.MAX_VALUE) {//도착 가능한 숫자
                if (i + n <= y) { // n 더하기
                    memo[i + n] = Math.min(memo[i + n], memo[i] + 1);
                }
                
                if (i * 2 <= y) {
                    memo[i * 2] = Math.min(memo[i * 2], memo[i] + 1);
                }
                
                if (i * 3 <= y) {
                    memo[i * 3] = Math.min(memo[i * 3], memo[i] + 1);
                }
            }
        }
        
        int answer = memo[y] == Integer.MAX_VALUE ? -1 : memo[y];
        return answer;
    }
}