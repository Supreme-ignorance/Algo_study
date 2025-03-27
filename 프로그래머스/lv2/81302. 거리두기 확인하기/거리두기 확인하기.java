import java.util.*;

class Solution {
    
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, -1, 0, 1};
    
    String[][] map;
    
    public int[] solution(String[][] places) {
        
        int[] answer = new int[5];
        Arrays.fill(answer, 1);
        
        for (int t = 0; t < 5; t++) {
            
            map = new String[5][5];
            for (int r = 0; r < 5; r++) {
                String line = places[t][r];
                for (int c = 0; c < 5; c++) {
                    map[r][c] = line.charAt(c) + "";
                }
            } //map 세팅
            
            outer:
            for (int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if ("P".equals(map[r][c])) {
                        if (!bfs(r, c)) {
                            answer[t] = 0;
                            break outer;
                        }
                    }
                }
            }
            
        }
        
        return answer;
    }
    
    private boolean bfs(int row, int col) {
        boolean[][] visited = new boolean[5][5];
        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(row, col));
        visited[row][col] = true;
        
        int count = 1;
        while(!que.isEmpty() && count < 3) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node node = que.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nextRow = node.r + dr[d];
                    int nextCol = node.c + dc[d];
                    
                    if (0 <= nextRow && nextRow < 5 && 0 <= nextCol && nextCol < 5 
                            && !visited[nextRow][nextCol]) {//경계처리 및 방문 여부 확인
                        if (map[nextRow][nextCol].equals("O")) {
                            que.add(new Node(nextRow, nextCol));
                            visited[nextRow][nextCol] = true;
                        }
                        if (map[nextRow][nextCol].equals("P")) {
                            return false;
                        }
                    }
                }
            }
            count++;
        }
        return true;
    }
    
    static class Node {
        int r;
        int c;
        
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}