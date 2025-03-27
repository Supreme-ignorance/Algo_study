import java.util.*;

class Solution {
    
    String[] strings;
    int[] minMemo;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        strings = words;
        int size = begin.length();
        visited = new boolean[words.length];
        
        int targetIndex = -1;
        boolean isContains = false;
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) {
                isContains = true;
                targetIndex = i;
                break;
            }
        }
        
        if (!isContains) {
            return 0;
        }
        
        minMemo = new int[words.length];
        Arrays.fill(minMemo, Integer.MAX_VALUE);
        minMemo[targetIndex] = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (i == targetIndex) {
                continue;
            }
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (target.charAt(j) == words[i].charAt(j)) {
                    count++;
                }
            }
            if (count == size - 1) {
                minMemo[i] = 1;
            }
        }
        
        for (int i = 0; i < words.length; i++) {
            if (minMemo[i] == Integer.MAX_VALUE) {
                dfs(i);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (isOneGap(begin, words[i])) {
                result = Math.min(result, minMemo[i]);
            }
        }
        
        int answer = result + 1;
        return answer;
    }
    
    private int dfs(int index) {
        if (minMemo[index] != Integer.MAX_VALUE) { //메모에 저장된 것이면 그것을 리턴
            return minMemo[index];
        }
        
        String current = strings[index];
        visited[index] = true;
        
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            if (index == i) { //자기껀 빼기
                continue;
            }
            if (isOneGap(current, strings[i])) {//하나 차이나면 후보에 넣는다.
                candidates.add(i);
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int candidate : candidates) { //후보들에서 값 가져오기
            if (!visited[candidate]) {
                min = Math.min(min, dfs(candidate));
            }
        }
        minMemo[index] = min + 1;
        return minMemo[index];
    }
    
    private boolean isOneGap(String current, String compare) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == compare.charAt(i)) {
                count++;
            }
        }
        if (count == current.length() - 1) {
            return true;
        }
        return false;
    }
}