class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int size = w * 2 + 1;
        
        int count = 0;
        
        int start = 1;
        int end = -1;
        for (int station : stations) {
            end = station - w;
            int range = end - start;
            
            if (range > 0) {
                // System.out.println("range : " + range);
                // System.out.println(getCount(size, range));
                count += getCount(size, range);
            }
            start = station + w + 1;
            if (start > n) {
                break;
            }
        }
        
        if (start <= n) {
            end = n + 1;
            int range = end - start;
            if (range > 0) {
                // System.out.println("range : " + range);
                // System.out.println(getCount(size, range));
                count += getCount(size, range);
            }
        }
        // System.out.println(count);
        
        int answer = count;
        return answer;
    }
    
    private int getCount(int size, int target) {
        int count = 0;
        while (target > size) {
            target -= size;
            count++;
        }
        return count + 1;
    }
}