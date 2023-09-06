class Solution {
    public int solution(int n) {
        int ans = n + 1;
        String ns = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < ns.length(); i++) {
            if (ns.charAt(i) == '1') count++;
        }
        while (true) {
            String ansString = Integer.toBinaryString(ans);
            int cnt = 0;
            for (int i = 0; i < ansString.length(); i++) {
                if (ansString.charAt(i) == '1') cnt++;
            }
            if (cnt == count) break;
            ans++;
        }
        return ans;
    }
}