import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        
        boolean exist = false;
        visited = new boolean[words.length];
        answer = 0;
        int stIdx = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                exist = true;
            }
            if (words[i].equals(begin)) {
                stIdx = i;
            }
        }
        
        if (!exist) return answer;
        
        // bfs
        Queue<List<String>> queue = new ArrayDeque<>();
        List<String> stList = new ArrayList<>();
        stList.add(begin);
        queue.add(stList);
        if (stIdx != -1) visited[stIdx] = true;
        
        while (!queue.isEmpty()) {
            List<String> currList = queue.poll();
            List<String> nextList = new ArrayList<>();
            for (int i = 0; i < currList.size(); i++) {
                String curr = currList.get(i);
                if (curr.equals(target)) return answer;
                for (int j = 0; j < words.length; j++) {
                    if (visited[j]) continue;
                    String next = words[j];
                    int diffCount = 0;
                    // 한글자만 다른지 검사
                    for (int k = 0; k < next.length(); k++) {
                        if (curr.charAt(k) != next.charAt(k)) {
                            diffCount++;
                        }
                    }

                    if (diffCount == 1) {
                        visited[j] = true;
                        if (next.equals(target)) return answer + 1;
                        nextList.add(next);
                    }
                }
            }
            if (nextList.size() != 0) queue.add(nextList);
            answer++;
        }
        return answer;
    }
}