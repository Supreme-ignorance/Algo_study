class Solution {
    public int solution(int n, int[] tops) {
        
        final int MOD = 10007;
        
        int[] makeAll = new int[n]; // 다음 삼각형에 영향을 안주는 완전 삼감형
        int[] makeMinus = new int[n]; // 다음 삼각형에 영향을 주는 불완전 삼각형
        
        if (tops[0] == 1) {
            makeAll[0] = 3;
            makeMinus[0] = 1;
        }
        else {
            makeAll[0] = 2;
            makeMinus[0] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            if (tops[i] == 1) {
                int all = makeAll[i - 1] * 3 % MOD; // 3
                int minus = makeAll[i - 1] % MOD; // 1
                // makeAll[i] += (makeAll[i - 1] * 3); // 3개 만들 수 있고
                // makeMinus[i] += makeAll[i - 1]; // 1개
                makeAll[i] += all;
                makeMinus[i] += minus;
                
                all = makeMinus[i - 1] * 2 % MOD;
                minus = makeMinus[i - 1] % MOD;
                // makeAll[i] += (makeMinus[i - 1] * 2); // 2개 만들 수 있고
                // makeMinus[i] += makeMinus[i - 1]; // 1개 
                makeAll[i] += all;
                makeMinus[i] += minus;
            }
            else {
                int all = makeAll[i - 1] * 2 % MOD; // 2
                int minus = makeAll[i - 1] % MOD;  // 1
                // makeAll[i] += (makeAll[i - 1] * 2); // 2개 만들 수 있고
                // makeMinus[i] += makeAll[i - 1]; // 1개
                makeAll[i] += all;
                makeMinus[i] += minus;
                
                all = makeMinus[i - 1] % MOD;
                minus = makeMinus[i - 1] % MOD;
                // makeAll[i] += (makeMinus[i - 1]); // 1개 만들 수 있고
                // makeMinus[i] += makeMinus[i - 1]; // 1개 
                makeAll[i] += all;
                makeMinus[i] += minus;
            }
            // makeAll[i] %= MOD;
            // makeMinus[i] %= MOD;
        }
        // System.out.println(makeAll[n - 1] + makeMinus[n - 1]);
        
        
        int answer = (makeAll[n - 1] + makeMinus[n - 1]) % MOD;
        return answer;
    }
}