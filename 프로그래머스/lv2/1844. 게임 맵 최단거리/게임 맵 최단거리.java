import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, -1, 0, 1};
    private int[][] visited;
    
    public int solution(int[][] maps) {
        
        visited = new int[maps.length][maps[0].length];
        bfs(0, 0, 1, maps);
        int answer = visited[visited.length - 1][visited[0].length - 1];
        return answer == 0 ? -1 : answer;
    }
    
    private void bfs(int row, int col, int count, int[][] maps) {
        Queue<Integer> rowQueue = new ArrayDeque<>();
        Queue<Integer> colQueue = new ArrayDeque<>();
        
        rowQueue.offer(row);
        colQueue.offer(col);
        visited[row][col] = count;
        
        while (!rowQueue.isEmpty()) {
            int size = rowQueue.size();
            count++;
            for (int i = 0; i < size; i++) {
                int r = rowQueue.poll();
                int c = colQueue.poll();
                for (int d = 0; d < 4; d++) {
                    int nextRow = r + dr[d];
                    int nextCol = c + dc[d];
                    if (0 <= nextRow && nextRow < maps.length && 
                        0 <= nextCol && nextCol < maps[0].length) {

                        if (maps[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == 0) {
                            rowQueue.offer(nextRow);
                            colQueue.offer(nextCol);
                            visited[nextRow][nextCol] = count;
                        }
                    }
                }
            }
        }
    }
}