import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int LIMIT = 200_000_000;

        int left = 1;
        int right = LIMIT;
        
        while (left <= right) {
            int mid = (left + right) / 2; //중간
            
            int count = 0;
            for (int i = 0; i < stones.length; i++) {
                if (stones[i] < mid) { // mid번째 사람보다 작은 스톤은 못밟는다.
                    count++;
                }
                else {
                    count = 0;
                }
                if (count >= k) {//징검다리를 못건넌다.
                    //징검다리를 못건너므로 right를 줄여준다.
                    break;
                }
            }
            if (count >= k) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        // System.out.println(right);
        
        int answer = right;
        return answer;
    }
}