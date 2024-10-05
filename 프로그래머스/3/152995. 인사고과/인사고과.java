import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int first = scores[0][0];
        int second = scores[0][1];
        
        int max = 0;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0] + b[1]) - (a[0] + a[1]));
        for (int[] score : scores) {
            pq.add(score);
            max = Math.max(max, score[0] + score[1]);
        }
        System.out.println(max);
        
        int rank = 1;
        int equals = 0;
        
        List<int[]> already = new ArrayList<>();
        outer:
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            // System.out.println(Arrays.toString(cur));

            already.add(cur);
            for (int[] before : already) {
                // System.out.println("cur: " + cur[0] + " " + cur[1]);
                // System.out.println("before: " + before[0] + " " + before[1]);
                // System.out.println();
                
                if (cur[0] < before[0] && cur[1] < before[1]) continue outer;
            }

            
            if (cur[0] + cur[1] == max) {
                equals++;
            }
            else {
                rank += equals;
                equals = 1;
                max = cur[0] + cur[1];
            }
            // System.out.println("max:" + max);
            // System.out.println("rank:" + rank);
            // System.out.println("equals:" + equals);
            
            if (cur[0] == first && cur[1] == second) return rank;
        }

        return -1;
    }
}