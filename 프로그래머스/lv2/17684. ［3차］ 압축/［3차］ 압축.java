import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        List<Integer> indexes = new ArrayList<>();
        
        List<String> dictionary = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dictionary.add("");
        
        for (int i = 0; i < 26; i++) {
            dictionary.add(((char) ('A' + i)) + "");
        }
        
        for (int i = 0; i < msg.length(); i++) {
            
            String target = "";
            String next = "";
            for (int j = msg.length(); j > i; j--) {
                target = msg.substring(i, j);
                if (dictionary.contains(target)) {
                    if (j + 1 <= msg.length()) {
                        next = msg.substring(i, j + 1);
                    }
                    break;
                }
            }
            if (!next.equals("")) {
                dictionary.add(next);
            }
            indexes.add(dictionary.indexOf(target));
            i += (target.length() - 1);
        } 
        
        int[] answer = indexes.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}