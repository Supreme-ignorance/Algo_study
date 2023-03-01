import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int n = triangle.length;
        // System.out.println(triangle.length);
        List<int[]> triangleWithZero = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int[] arr = new int[i + 2];
            for (int j = 1; j <= i; j++) {
                arr[j] = triangle[i - 1][j - 1];
            }
            // System.out.println(Arrays.toString(arr));
            triangleWithZero.add(arr);
        }
        
        
        for (int i = 1; i < triangleWithZero.size(); i++) {
            for (int j = 1; j <= i + 1; j++) {
                triangleWithZero.get(i)[j] = triangleWithZero.get(i)[j] + Math.max(triangleWithZero.get(i - 1)[j - 1], triangleWithZero.get(i - 1)[j]);
            }
        }
        
        Arrays.sort(triangleWithZero.get(n - 1));
        
        int answer = triangleWithZero.get(n - 1)[n + 1];
        return answer;
    }
}