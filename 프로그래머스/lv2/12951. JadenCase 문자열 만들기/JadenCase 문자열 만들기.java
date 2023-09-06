class Solution {
    public String solution(String s) {
        int len = s.length();
        String answer = "";
        
        char first = s.charAt(0);
        if (first >= 'a' && first <= 'z') {
            first = Character.toUpperCase(first);
        }
        answer += String.valueOf(first);
        
        for (int i = 1; i < len; i++) {
            char before = s.charAt(i - 1);
            char curr = s.charAt(i);
            if (curr >= 'a' && curr <= 'z' && before == ' ') {
                curr = Character.toUpperCase(curr);
            } else if (curr >= 'A' && curr <= 'Z' && before != ' ') {
                curr = Character.toLowerCase(curr);
            }
            answer += String.valueOf(curr);
        }
        return answer;
    }
}