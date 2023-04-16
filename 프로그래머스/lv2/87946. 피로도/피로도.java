class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, boolean[] visited, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            if(!visited[i] && k>=dungeons[i][0]){
                visited[i] = true;
                k -= dungeons[i][1];
                dfs(k, dungeons, visited, cnt+1);
                visited[i] = false;
                k += dungeons[i][1];
            }
        }
    }
}