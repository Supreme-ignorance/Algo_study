import java.util.*;

class Solution {
    
    int N;
    Map<Integer, String> map;
    
    public String solution(int n, int t, int m, int p) {
        N = n;
        map = new HashMap<>();
        map.put(10, "A");
        map.put(11, "B");
        map.put(12, "C");
        map.put(13, "D");
        map.put(14, "E");
        map.put(15, "F");
        
        String[] members = new String[m];
        for (int i = 0; i < m; i++) {
            members[i] = "";
        }
        
        int order = 0;
        
        outer:
        for (int i = 0; ; i++) {
            
            String number = makeN(i);
            char[] numbers = number.toCharArray();
            for (int j = 0; j < numbers.length; j++) {
                int targetOrder = order + j;
                if (targetOrder >= m) {
                    targetOrder %= m;
                }
                members[targetOrder] = members[targetOrder] + numbers[j];
                
                if (members[p - 1].length() == t) {
                    break outer;
                }
            }
            

            order += numbers.length;
            // System.out.println(order);
            if (order >= m) {
                order %= m;
            }
        }
        
        System.out.println(Arrays.toString(members));
        
        String answer = members[p - 1];
        return answer;
    }
    
    public String makeN(int number) {
        if (number == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(number != 0) {
            int rest = number % N;
            String target = "";
            if (rest >= 10) {
                target = map.get(rest);
            }
            else {
                target = rest + "";
            }
            sb.append(target);
            number /= N;
        }
        return sb.reverse().toString();
    }
}