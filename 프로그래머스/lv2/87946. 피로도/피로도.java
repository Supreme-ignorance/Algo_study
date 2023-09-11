class Solution {

    int[][] dungeons;
    boolean[] visited;
    int limit;
    
    int max;
        
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        limit = dungeons.length;
        visited = new boolean[limit];
        
        dfs(0, k, 0);
        System.out.println(max);
        
        int answer = max;
        return answer;
        
    }
    
    public void dfs(int depth, int current, int count) {
        if (depth == limit) {
            if (count > max) {
                max = count;
            }
            return;
        }
        
        for (int i = 0; i < limit; i++) {
            
            if (visited[i]) {
                continue;
            }
            
            int need = dungeons[i][0];
            int use = dungeons[i][1];
            
            visited[i] = true;
            if (current >= need) {
                dfs(depth + 1, current - use, count + 1);
            }
            else {
                dfs(depth + 1, current, count);
            }
            visited[i] = false;
        }
    }
}