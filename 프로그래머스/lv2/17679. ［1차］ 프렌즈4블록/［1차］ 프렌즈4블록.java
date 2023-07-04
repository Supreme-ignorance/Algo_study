import java.util.*;

class Solution {
    
    private int[] dr = {0, 1, 1};
    private int[] dc = {1, 0, 1};
    char[][] map;
    int count;
    List<int[]> locations;
    
    public int solution(int m, int n, String[] board) {
        
        map = new char[m][n];
        for (int r = 0; r < m; r++) {
            char[] chars = board[r].toCharArray();
            for (int c = 0; c < n; c++) {
                map[r][c] = chars[c];
            }
        }
    
        locations = new ArrayList<>();
        do {
            locations = new ArrayList<>();
            for (int r = 0; r < m - 1; r++) {
                for (int c = 0; c < n - 1; c++) {
                    if (isFourth(r, c)) {
                        locations.add(new int[] {r, c});
                    }
                }
            }
        
            for (int[] ints : locations) {
                deleteBlock(ints);
            }
            
            for (int c = 0; c < n; c++) {
                StringBuilder sb = new StringBuilder();
                for (int r = m - 1; r >= 0; r--) {
                    if (map[r][c] != 'e') {
                        sb.append(map[r][c]);
                        map[r][c] = 'e';
                    }
                }
                for (int i = 0; i < sb.length(); i++) {
                    map[m - 1 - i][c] = sb.charAt(i);
                }
            }
        } while (!locations.isEmpty());
       
        int answer = count;
        return answer;
    }
    
    private void printMap() {
        for (char[] chars : map) {
            System.out.println(Arrays.toString(chars));
        }
    }
    
    private boolean isFourth(int row, int col) {
        if (map[row][col] == 'e') {
            return false;
        }
        char ch = map[row][col];
        for (int d = 0; d < 3; d++) {
            int nextRow = row + dr[d];
            int nextCol = col + dc[d];
            if (ch != map[nextRow][nextCol]) {
                return false;
            }
        }
        return true;
    }
    
    private void deleteBlock(int[] locations) {
        int row = locations[0];
        int col = locations[1];
        if (map[row][col] != 'e') {
            map[row][col] = 'e';
            count++;
        }
        
        for (int d = 0; d < 3; d++) {
            int nextRow = row + dr[d];
            int nextCol = col + dc[d];
            if (map[nextRow][nextCol] != 'e') {
                map[nextRow][nextCol] = 'e';
                count++;
            }
        }
    }
}