import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> hs = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 부분수열 길이
        for (int len = 1; len <= elements.length; len++) {
            
            // 첫번째 값
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += elements[i]; 
                queue.add(elements[i]);
            }
            
            int idx = len;
            hs.add(sum);
            
            // elements 길이 - 1만큼 돌리기
            int count = elements.length - 1;
            while (count != 0) {
                if (idx == elements.length) {
                    idx = 0;
                }
                
                int minusElement = queue.poll();
                sum -= minusElement;
                int plusElement = elements[idx];
                sum += plusElement;
                hs.add(sum);
                queue.add(elements[idx]);
                idx++;
                count--;
            }
            queue.clear();
        }
        
//         Iterator<Integer> iterSet = hs.iterator();
//         while(iterSet.hasNext()) {
//             System.out.print(iterSet.next() +" ");
//         }
        
        
        
        int answer = hs.size();
        return answer;
    }
}