import java.util.*;

class Solution {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int target = n;
        
        while (target != 0) {
            int rest = target % k;
            target /= k;
            sb.append(rest + "");
        }
        String result = sb.reverse().toString();
        String[] splits = result.split("0");
        
        int count = 0;
        for (String number : splits) {
            if (number.equals("")) {
                continue;
            }
            if (isPrime(Long.parseLong(number))) {
                count++;
            }
        }
        
        int answer = count;
        return answer;
    }
    
    private boolean isPrime(long number) {
        if (number == 1) { //1이면 소수가 아니다.
            return false;
        }
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}