import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq;
    public long solution(int n, int[] works) {
        pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        while (n != 0) {
            n--;
            if (pq.isEmpty()) break;
            int curr = pq.poll();
            int next = curr - 1;
            if (next <= 0) continue;
            pq.add(next);
        }
        
        long answer = 0;
        while (!pq.isEmpty()) {
            int remain = pq.poll();
            System.out.println(remain);
            answer += (long) Math.pow(remain, 2);
        }
        return answer;
    }
}