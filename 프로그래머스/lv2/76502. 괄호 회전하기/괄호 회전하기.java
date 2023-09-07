import java.util.*;

class Solution {
    public int solution(String s) {
        
        Stack<Character> stk = new Stack<>();
        
        int len = s.length();
        int count = 0;
        int answer = 0;
        
        while (count < len) {
            boolean found = true;
            for (int i = 0; i < len; i++) {
                char curr = s.charAt(i);
                if ((curr == ')' || curr == ']' || curr == '}') && stk.isEmpty()) {
                    found = false;
                    break;
                }
                
                if (curr == '(' || curr == '[' || curr == '{') stk.push(curr);
                
                if (curr == ')') {
                    if (stk.peek() == '(') stk.pop();
                    else {
                        found = false;
                        break;
                    }
                }
                
                if (curr == ']') {
                    if (stk.peek() == '[') stk.pop();
                    else {
                        found = false;
                        break;
                    }
                }
                
                if (curr == '}') {
                    if (stk.peek() == '{') stk.pop();
                    else {
                        found = false;
                        break;
                    }
                }
            } 
            if (!stk.isEmpty()) {
                stk = new Stack<>();
                found = false;
            }
            if (found) answer++;
            
            char first = s.charAt(0);
            s = s.substring(1, s.length());
            s += first;
            count++;
        }
        
        return answer;
    }
}