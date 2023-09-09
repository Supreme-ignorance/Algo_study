import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        int len = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        
        int ci = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            int currA = A[i];
            while (ci >= 0) {
                int currB = B[ci];
                // System.out.println(currA + " vs " + currB);
                if (currA < currB) {
                    answer++;
                    ci--;
                    break;
                } else if (currA >= currB) {
                    break;
                }
                ci--;
            }
        }
        return answer;
    }
}