import java.util.*; 

class Solution {
    
    private int[] minCount = new int[4]; //출발지에서 도착지까지 최소한으로 도착하는 방법
    private int[] dr = {1, 0, 0, -1};
    private int[] dc = {0, -1, 1, 0};
    private int range;
    private int overCount;
    private StringBuilder sb;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        
        range = getMinCount(x, y, r, c);
        if (range > k || (k - range) % 2 != 0) {
            String answer = "impossible";
            return answer;
        }
        overCount = (k - range) / 2;
        
        sb = new StringBuilder();
        process(x, y, n, m);
        
        String answer = sb.toString();
        System.out.println(answer);
        return answer;
    }
    
    private void process(int x, int y, int n, int m) {
        while (x < n) {
            if (minCount[0] == 0 && overCount == 0) {
                break;
            }
            
            if (minCount[0] > 0) {
                minCount[0]--;
            }
            else {//minCount[0] == 0
                    overCount--;
                    minCount[3]++;
            }
            sb.append("d");
            x++;
        }
        while (y > 1) {
            if (minCount[1] == 0 && overCount == 0) {
                break;
            }
    
            if (minCount[1] > 0) {
                minCount[1]--;
            }
            else {//minCount[1] == 0
                    overCount--;
                    minCount[2]++;
            }
            sb.append("l");
            y--;
        }
        while (overCount != 0) {
            sb.append("rl");
            overCount--;
        }
        while (minCount[2] > 0) {
            sb.append("r");
            minCount[2]--;
        }
        while (minCount[3] > 0) {
            sb.append("u");
            minCount[3]--;
        }
    }
    
    private int getMinCount(int x, int y, int r, int c) {
        // d: 0, l: 1, r: 2, u: 3
        int rowLength = Math.abs(x - r);
        int colLength = Math.abs(y - c);
        
        if (r > x) {
            minCount[0] = rowLength;
        }
        else {
            minCount[3] = rowLength;
        }
        
        if (c > y) {
            minCount[2] = colLength;
        }
        else {
            minCount[1] = colLength;
        }
        
        int range = rowLength + colLength;
        return range;
    }
}