class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0L;
        long left = 0L;
        long right = 1_000_000_000L * 1_000_000_000L;
        long mid;
        long temp;


        while (left <= right) {
            mid = (left + right) / 2L;
            temp = 0L;
            for (long time : times) {
                temp += (mid / time);
            }
            
            if (temp >= n) {
                    answer = mid;
                right = mid - 1L;

            }
            else {
                left = mid + 1L;
            }
        }
        
        
        
        return answer;
    }
    
    private long getPerson(int[] times, long mid) {
        long count = 0L;
        for (long time : times) {
            count += (mid / (long) time);
        }
        return count;
    }
}