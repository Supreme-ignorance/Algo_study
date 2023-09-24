import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int ansRow = arr1.length;
        int ansCol = arr2[0].length;
        int len = arr1[0].length;
        int[][] answer = new int[ansRow][ansCol];
        
        for (int i = 0; i < ansRow; i++) {
            int[] currArr1 = arr1[i];
            for (int j = 0; j < ansCol; j++) {
                int sum = 0;
                for (int k = 0; k < len; k++) {
                    sum += currArr1[k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        
        return answer;
    }
}