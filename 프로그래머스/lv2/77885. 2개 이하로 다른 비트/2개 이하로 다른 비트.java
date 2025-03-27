import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            
            String binary = toBinary(numbers[i]);
            
            if (!binary.contains("0")) {
                binary = "0" + binary;
                binary = String.valueOf(binary.charAt(1)) + binary.charAt(0) + binary.substring(2);
            }
            else {
                int lastIndex = binary.lastIndexOf("0");
                binary = binary.substring(0, lastIndex) + "10" + binary.substring(lastIndex + 2); 
        
            }
            answer[i] = binaryToLong(binary);
        }
                
        return answer;
    }
    
    private String toBinary(long number) {
        
        StringBuilder sb = new StringBuilder();
        while(number != 0) {
            sb.append(number % 2);
            number /= 2;
        }
        return sb.reverse().toString();
        
    }
    
    private long binaryToLong(String binary) {
        String target = new StringBuilder(binary).reverse().toString();
        long answer = 0;
        long current = 1L;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '1') {
                answer += current;
            }
            current *= 2;
        }
        
        return answer;
    }
}