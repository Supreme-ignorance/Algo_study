import java.util.*;

class Solution {
    
    List<List<Integer>> sequence;
    boolean[] visited;
    int[] cards;
    
    public int solution(int[] cards) {
        this.cards = cards;
        sequence = new ArrayList<>();
        visited = new boolean[cards.length];
        
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                sequence.add(new ArrayList<>());
                bfs(i);
            }
        }
        
        if (sequence.size() == 1) {
            return 0;
        }
        
        Collections.sort(sequence, (a, b) -> b.size() - a.size());
        
        return sequence.get(0).size() * sequence.get(1).size();
    }
    
    void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        addInLastSequence(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int nextIdx = cards[cur] - 1;
            
            if (!visited[nextIdx]) {
                q.add(nextIdx);
                visited[nextIdx] = true;
                addInLastSequence(nextIdx);
            }
        }
    }
    
    void addInLastSequence(int value) {
        sequence.get(sequence.size() - 1).add(value);
    }
}