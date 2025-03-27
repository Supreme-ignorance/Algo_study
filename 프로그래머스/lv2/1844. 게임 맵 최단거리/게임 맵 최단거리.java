import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    public int solution(int[][] maps) {
        
        int ROW = maps.length;
        int COL = maps[0].length;
        
        //row, col, 이동 카운트
        Queue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(2)));
        pq.add(Arrays.asList(0, 0, 1));
        // boolean[][] visited = new boolean[ROW][COL];
        
        while (!pq.isEmpty()) {
            List<Integer> cur = pq.poll();
            int row = cur.get(0); 
            int col = cur.get(1);
            int count = cur.get(2);
            
            //최적의 해를 구했으므로 리턴
            if (row == ROW - 1 && col == COL - 1) {
                return count;
            }
            // visited[row][col] = true;

            for (int d = 0; d < 4; d++) {
                int nextRow = row + dr[d];
                int nextCol = col + dc[d];
                
                if (nextRow < 0 || ROW <= nextRow || nextCol < 0 || COL <= nextCol) {//맵 경계처리
                    continue;
                }
                if (maps[nextRow][nextCol] != 0) {
                    //이미 지나온 경로는 더 이상 거치지 않도록 0 설정
                    maps[nextRow][nextCol] = 0;
                    pq.add(Arrays.asList(nextRow, nextCol, count + 1));
                }
                
            }
        }
        // pq의 모든 것이 빠져도 도착 못하면 갈 수 있는 방법이 없으므로 -1 반환
        return -1; 
    }
}