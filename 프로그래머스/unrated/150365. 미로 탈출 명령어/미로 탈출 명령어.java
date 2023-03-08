import java.util.*;

class Solution {
    char[] dl = {'d', 'l', 'r', 'u'};
    String result;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {        
        int distance = Math.abs(x - r) + Math.abs(y - c);        
        if (distance > k) {
            return "impossible";
        }
        
        if (distance < k && (distance % 2 != k % 2)) {
            return "impossible";
        }

        result = "";
        
        escape(n, m, x, y, r, c, k);
        
        if (result == null) {
            return "impossible";
        }
        
        return result;
    }
    
    private void escape(int n, int m, int x, int y, int r, int c, int k) {
        int cr = x - 1;
        int cc = y - 1;
        
        int er = r - 1;
        int ec = c - 1;
        
        while (k != 0) {
            int range = Math.abs(cr - er) + Math.abs(cc - ec);
            
            if (cr + 1 < n) {
                int nRange = Math.abs(cr + 1 - er) + Math.abs(cc - ec);
                if (k - 1 >= nRange) {
                    cr++;
                    result += 'd';
                    k--;
                    continue;
                }
            }
            
            if (cc - 1 >= 0) {
                int nRange = Math.abs(cr - er) + Math.abs(cc - 1 - ec);
                if (k - 1 >= nRange) {
                    cc--;
                    result += 'l';
                    k--;
                    continue;
                }
            }
            
            if (cc + 1 < m) {
                int nRange = Math.abs(cr - er) + Math.abs(cc + 1 - ec);
                if (k - 1 >= nRange) {
                    cc++;
                    result += 'r';
                    k--;
                    continue;
                }
            }
            
            if (cr - 1 >= 0) {
                int nRange = Math.abs(cr - 1 - er) + Math.abs(cc - ec);
                if (k - 1 >= nRange) {
                    cr--;
                    result += 'u';
                    k--;
                    continue;
                }
            }
        }
    }
    
  
}