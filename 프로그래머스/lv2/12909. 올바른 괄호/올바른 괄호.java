import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stk = new Stack<>();
        boolean answer = true;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                stk.push(curr);
            }
            
            if (curr == ')' && !stk.isEmpty()) {
                stk.pop();
            } else if (curr == ')' && stk.isEmpty()) {
                answer = false;
                break;
            } 
        }
        if (!stk.isEmpty()) answer = false;
        return answer;

    }
}