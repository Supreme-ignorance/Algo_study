class Solution {
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int st = i;
            while (sum < n) {
                sum += st;
                st++;
            }
            if (sum == n) count++;
        }
        return count;
    }
}