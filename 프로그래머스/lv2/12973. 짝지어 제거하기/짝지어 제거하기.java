import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (!stk.isEmpty() && stk.peek() == curr) {
                stk.pop();
            } else if (!stk.isEmpty() && stk.peek() != curr) {
                stk.push(curr);
            } else if (stk.isEmpty()) {
                stk.push(curr);
            }
        }
        
        if (stk.isEmpty()) return 1;
        else return 0;
    }
}