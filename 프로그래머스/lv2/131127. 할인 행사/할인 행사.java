import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        for(int i=0; i<10; i++){
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0)+1);
        }
        
        if(check(wantMap, discountMap)) answer++;
        
        for(int i=0; i<discount.length-10; i++){
            discountMap.put(discount[i], discountMap.get(discount[i])-1);
            discountMap.put(discount[i+10], discountMap.getOrDefault(discount[i+10], 0)+1);
            if(check(wantMap, discountMap)){
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean check(Map<String, Integer> wantMap, Map<String, Integer> discountMap){
        for(String s : wantMap.keySet()){
            if(wantMap.get(s) != discountMap.get(s)) return false;
        }
        
        return true;
    }
}