import java.util.*;

class Solution {
    static int minValue;
    static int minIndex;
    
    public int solution(int[] a) {
        int len = a.length;
        minValue = 1_000_000_001;
        minIndex = -1;
        
        // 최솟값 찾기
        for (int i = 0; i < len; i++) {
           if (minValue > a[i]) {
               minValue = a[i];
               minIndex = i;
           }
        }
        
        int answer = 1;
        
        int leftMin = 1_000_000_001;
        // 왼쪽에서 출발
        for (int i = 0; i < minIndex; i++) {
            if (a[i] < leftMin) {
                leftMin = a[i];
                answer++;
            }
        }
        
        int rightMin = 1_000_000_001;
        // 오른쪾에서 출발
        for (int i = len - 1; i > minIndex; i--) {
            if (a[i] < rightMin) {
                rightMin = a[i];
                answer++;
            }
        }
        
        return answer;
    }
}