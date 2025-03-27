import java.util.*;

class Solution {
    
    Queue<Character> que;
    Queue<Character> leftQue;
    Queue<Character> rightQue ;  
        
    public String solution(String p) {
        
        String str = p;
        
        String answer = recursive(str);
        return answer;
    }
    
    public String recursive(String str) {
        if (str.equals("")) {
            return "";
        }
        int substringIndex = getSubstringIndex(str);
        String u = str.substring(0, substringIndex);
        String v = "";
        if (substringIndex < str.length()) {
            v = str.substring(substringIndex, str.length());
        }
        if (isComplete(u)) {
            return u + recursive(v);
        }
        else {
            String temp = "(" + recursive(v) + ")";
                
            StringBuilder sb = new StringBuilder(u);
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(0);
            int size = sb.length();
            
            for (int i = 0; i < size; i++) {
                if (sb.charAt(i) == '(') {
                    sb.append(")");
                }
                else {
                    sb.append("(");
                }    
            }            
            String result = sb.substring(size, sb.length());
            temp += result;
            return temp;
        }
    }
    
    public boolean isComplete(String str) {
        char[] chars = str.toCharArray();
        Queue<Character> temp = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                temp.add(chars[i]);
            }
            else {
                if (!temp.isEmpty() && temp.peek() == '(') {
                    temp.poll();
                }
                else {
                    return false;
                }
            }
        }
        return temp.isEmpty();
    }
    
    public int getSubstringIndex(String str) {
        
        char[] chars = str.toCharArray();
        leftQue = new ArrayDeque<>();
        rightQue = new ArrayDeque<>();
        
        int substringIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                leftQue.add(chars[i]);
            }
            else { // ')'
                rightQue.add(chars[i]);
            }
            
            if (leftQue.size() == rightQue.size()) {
                return substringIndex = i + 1;

            }
        }
        return -1;
    }
}