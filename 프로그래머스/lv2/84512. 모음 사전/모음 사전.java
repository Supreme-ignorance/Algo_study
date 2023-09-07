import java.util.*;

class Solution {
    
    String[] arr = {"A", "E", "I", "O", "U"};
    int count = 0;
    String target;
    int result;
    
    public int solution(String word) {
        target = word;
        
        dfs(0, "");
        // System.out.println(result);
        
        int answer = result;
        return answer;
    }
    
    private void dfs(int depth, String current) {
        if (depth == 5) { //기저 조건
            if (current.equals(target)) {
                result = count;
            }
            return;
        }
        
        if (current.equals(target)) {
            result = count;
            return;
        }
        
        for (int i = 0; i < arr.length; i++) {
            count++;
            dfs(depth + 1, current + arr[i]);
        }
    }
}