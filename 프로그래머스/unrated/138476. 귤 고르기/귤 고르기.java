import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int l : tangerine){
            map.put(l, map.getOrDefault(l, 0)+1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values, Comparator.reverseOrder());
        int idx=0;
        while(k>0){
            k -= values.get(idx);
            idx++;
            answer++;
        }
        
        return answer;
    }
}