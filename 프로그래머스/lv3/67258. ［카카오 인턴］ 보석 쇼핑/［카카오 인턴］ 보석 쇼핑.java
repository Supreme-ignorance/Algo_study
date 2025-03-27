import java.util.*;

class Solution {
    
    private Set<String> set;
    private Map<String, Integer> map;
    
    private int size;
    private int start;
    private int end;
    
    public int[] solution(String[] gems) {
        
        set = new HashSet<>();
        for (int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        int left = 0;
        int right = set.size();
        map = new HashMap<>();
        for (int i = left; i < right; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1); //기본 사이즈 세팅
        }
        if (check()) {
            return new int[] {left + 1, right};
        }

        size = Integer.MAX_VALUE;
        start = 0;
        end = 0;
        
        while (true) {
            
            if (set.size() == map.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                
                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
            }
            else if (right == gems.length) {
                break;
            }
            else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }
            
            if (map.size() == set.size()) {
                if (right - left < size) {
                    size = right - left;
                    start = left + 1;
                    end = right;
                }
            }
            
        }
        
        int[] answer = {start, end};
        return answer;
    }
    
    private void compare(int length, int left, int right) {
        if (length == size) {
            if (left < start) {
                start = left;
                end = right;
            }
        }
        if (length < size) {
            size = length;
            start = left;
            end = right;
        }
    }
    
    private boolean check() {
        if (set.size() != map.size()) {
            return false;
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 0) {
                return false;
            }
        }
        return true;
    }
}