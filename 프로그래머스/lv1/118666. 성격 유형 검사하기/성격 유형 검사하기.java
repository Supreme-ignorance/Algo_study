import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for (int i = 0; i < survey.length; i++) {
            char no = survey[i].charAt(0);
            char yes = survey[i].charAt(1);
            int c = choices[i];

            if (c == 1) {
                map.put(no, map.get(no) + 3);
            }
            else if (c == 2) {
                map.put(no, map.get(no) + 2);
            }
            else if (c == 3) {
                map.put(no, map.get(no) + 1);
            }
            else if (c == 4) {
                continue;
            }
            else if (c == 5) {
                map.put(yes, map.get(yes) + 1);
            }
            else if (c == 6) {
                map.put(yes, map.get(yes) + 2);
            }
            else if (c == 7) {
                map.put(yes, map.get(yes) + 3);
            }
        }
        
        String answer = "";
        answer += (map.get('R') >= map.get('T') ? "R" : "T");
        answer += (map.get('C') >= map.get('F') ? "C" : "F");
        answer += (map.get('J') >= map.get('M') ? "J" : "M");
        answer += (map.get('A') >= map.get('N') ? "A" : "N");
        
        return answer;
    }
}