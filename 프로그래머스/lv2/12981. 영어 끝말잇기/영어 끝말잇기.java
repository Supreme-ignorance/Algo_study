import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> wordSet = new HashSet<>();
        wordSet.add(words[0]);
        boolean midOut = false;
        int idx = 0;
        for (int i = 1; i < words.length; i++) {
            String before = words[i - 1];
            String curr = words[i];
            // 끝말 잇기 확인
            char beforeLast = before.charAt(before.length() - 1);
            char currFirst = curr.charAt(0);
            if (beforeLast != currFirst) {
                midOut = true;
                idx = i;
                break;
            }
            // 단어 중복 확인
            if (wordSet.contains(curr)) {
                midOut = true;
                idx = i;
                break;
            }
            
            wordSet.add(words[i]); 
        }
        
        if (!midOut) return new int[] {0 , 0};
        else {
            int personIdx = idx % n + 1;
            int orderIdx = idx / n + 1;
            return new int[] {personIdx, orderIdx};
        }
        
    }
}