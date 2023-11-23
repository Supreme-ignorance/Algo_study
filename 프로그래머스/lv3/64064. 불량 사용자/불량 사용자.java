import java.util.*;

class Solution {
    
    int size;
    boolean[] used;
    
    String[] user_id;
    String[] banned_id;
    
    Set<String> output;
    Set<Set<String>> set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        size = banned_id.length;
        output = new HashSet<>();
        // used = new boolean[user_id.length];
        
        dfs(0);
        int answer = set.size();
        return answer;
    }
    
    private void dfs(int index) {
        if (index == size) {
            // System.out.println(output);
            set.add(new HashSet<>(output));
            return;
        }
        
        String target = banned_id[index];
        
        for (int i = 0; i < user_id.length; i++) {
            if (!output.contains(user_id[i]) && target.length() == user_id[i].length()) {
                if (check(target, user_id[i])) {
                    // used[i] = true;
                    output.add(user_id[i]);
                    dfs(index + 1);
                    output.remove(user_id[i]);
                    // used[i] = false;
                }
            }
        }
    }
    
    private boolean check(String target, String compare) {
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '*') continue;
            
            if (target.charAt(i) != compare.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}