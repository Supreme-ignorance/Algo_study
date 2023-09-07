import java.util.*;

class Solution {
    static PriorityQueue<int[]> pq;
    static int[] count;
    public int solution(int k, int[] tangerine) {
        
        count = new int[10_000_001];
        for (int i = 0; i < tangerine.length; i++) {
            int curr = tangerine[i];
            count[curr]++;
        }
        
        pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) continue;
            pq.add(new int[] {count[i], i});
        }
        
        int answer = 0;
        while (k > 0) {
            int[] temp = pq.poll();
            k -= temp[0];
            answer++;
        }
        
        return answer;
    }
}