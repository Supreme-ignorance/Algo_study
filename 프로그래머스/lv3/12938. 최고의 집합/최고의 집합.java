import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }
        
        int fill = s / n;
        int rest = s % n;
        
        int[] answer = new int[n];
        Arrays.fill(answer, fill);
        for (int i = 0; i < rest; i++) {
            answer[i]++;
        }
        Arrays.sort(answer);
        return answer;
    }
}