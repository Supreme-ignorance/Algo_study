import java.util.*;

class Solution {
    
    public int solution(String[] want, int[] number, String[] discount) {
        
        int count = 0;
        
        Map<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        
        Map<String, Integer> discounts = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discounts.put(discount[i], discounts.getOrDefault(discount[i], 0) + 1);
        }
        if (isEqual(wants, discounts)) {
            count++;
        }
        
        for (int i = 10; i < discount.length; i++) {
            discounts.put(discount[i], discounts.getOrDefault(discount[i], 0) + 1);
            discounts.put(discount[i - 10], discounts.getOrDefault(discount[i - 10], 0) - 1);
            
            if (discounts.get(discount[i - 10]) == 0) {
                discounts.remove(discount[i - 10]);
            }
            if (isEqual(wants, discounts)) {
                count++;
            }
        }
        
        // System.out.println(count);
        
        int answer = count;
        return answer;
    }
    
    private boolean isEqual(Map<String, Integer> wants, Map<String, Integer> discounts) {
        // System.out.println(discounts);
        if (wants.size() != discounts.size()) {
            return false;
        }
        
        // boolean[] check = new boolean[wants.size()];
        for (String key : wants.keySet()) {
            if (!discounts.containsKey(key)) {
                return false;
            }
            //키를 가지고 있음
            if (discounts.get(key) != wants.get(key)) {
                return false;
            }
        }
        return true;
    }
}