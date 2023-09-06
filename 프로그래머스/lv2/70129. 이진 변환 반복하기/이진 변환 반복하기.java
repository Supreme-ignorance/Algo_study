class Solution {
    public int[] solution(String s) {
        int zeroCount  = 0;
        int count = 0;
        while (!s.equals("1")) {
            count++;
            int len = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') len++;
            }
            zeroCount += s.length() - len;
            s = Integer.toBinaryString(len);
        }
        return new int[] {count, zeroCount};
        
    }
}