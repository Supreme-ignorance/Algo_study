class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = 1_000_000_000L * 1_000_000_000L;
        long mid;
        long tmp;


        while (left <= right) {
            mid = (left + right)/2;
            System.out.println(left +"+"+ right + ":"+mid);
            tmp = 0;
            for(long time: times) {
                tmp += (mid / time);
            }

            System.out.println((tmp >= n) + " tmp : " + tmp);
            if (tmp >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return answer;
    }
}