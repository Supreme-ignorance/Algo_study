class Solution {

    static long answer = 0;
    public long solution(int[] sequence) {

        for (int i = 0; i < sequence.length; i+=2) {
            sequence[i] = sequence[i]*-1;
        }
        getMaxSum(sequence);
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = sequence[i]*-1;
        }
        getMaxSum(sequence);
        return answer;
    }

    static void getMaxSum(int[] arr){
        long [] dp = new long[arr.length];

        dp[0] = arr[0];
        answer = Math.max(answer, dp[0]);
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(0, dp[i-1])+arr[i];
            answer = Math.max(answer, dp[i]);
        }
    }
}