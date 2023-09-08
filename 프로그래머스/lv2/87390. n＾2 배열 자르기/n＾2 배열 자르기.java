class Solution {
    public int[] solution(int n, long left, long right) {
        int idx = Long.valueOf(right - left).intValue();
        int[] answer = new int[idx + 1];
        
        
        idx = 0;
        for (long curr = left; curr <= right; curr++) {
            int startIdx = Long.valueOf(curr / n).intValue();
            int ansIdx = Long.valueOf(curr % n).intValue();
            int st = 1 + startIdx;
            answer[idx++] = (startIdx >= ansIdx) ? st : ansIdx + 1;      
        }

        return answer;
    }
}