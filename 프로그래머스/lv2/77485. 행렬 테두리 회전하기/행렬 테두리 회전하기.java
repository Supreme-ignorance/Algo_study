import java.util.*;

class Solution {
    
    int min;
    
    int[][] map;
    
    int[] answer; 
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        map = new int[rows][columns];
        int number = 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                map[r][c] = number++;
            }
        }
        
        answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int f_row = queries[i][0];
            int f_col = queries[i][1];
            int s_row = queries[i][2];
            int s_col = queries[i][3];
            
            int result = change(f_row, f_col, s_row, s_col);
            answer[i] = result;
        }
        
        return answer;
    }
    
    private int change(int f_row, int f_col, int s_row, int s_col) {
        f_row -= 1;
        f_col -= 1;
        s_row -= 1;
        s_col -= 1;
        
        min = map[f_row][f_col];
        int beforeNumber = map[f_row][f_col];
        for (int c = f_col + 1; c <= s_col; c++) {
            int temp = map[f_row][c];
            map[f_row][c] = beforeNumber;
            beforeNumber = temp;
            checkMin(beforeNumber);
        }
        for (int r = f_row + 1; r <= s_row; r++) {
            int temp = map[r][s_col];
            map[r][s_col] = beforeNumber;
            beforeNumber = temp;
            checkMin(beforeNumber);    
        }
        for (int c = s_col - 1; c >= f_col; c--) {
            int temp = map[s_row][c];
            map[s_row][c] = beforeNumber;
            beforeNumber = temp;
            checkMin(beforeNumber);
        }
        for (int r = s_row - 1; r >= f_row; r--) {
            int temp = map[r][f_col];
            map[r][f_col] = beforeNumber;
            beforeNumber = temp;
            checkMin(beforeNumber);
        }
        
        return min;
    }
    
    private void checkMin(int number) {
        if (min > number) {
            min = number;
        }
    }
}