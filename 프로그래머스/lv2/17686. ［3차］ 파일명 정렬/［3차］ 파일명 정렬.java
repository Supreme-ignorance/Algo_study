import java.util.*;

class Solution {
    
    private int numberStart = -1;
    private int tailStart = -1;
    
    public String[] solution(String[] files) {
        
        File[] fileList = new File[files.length];
        for (int k = 0; k < files.length; k++) {
            char[] chars = files[k].toCharArray();
            
            int numberStart = -1;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {
                    numberStart = i;
                    break;
                }
            }
            
            String header = files[k].substring(0, numberStart);
            // System.out.println(header);
            
            int tailStart = chars.length;
            for (int i = numberStart; i < chars.length; i++) {
                if (!Character.isDigit(chars[i])) {
                    tailStart = i;
                    break;
                }
            }
            String number = files[k].substring(numberStart, tailStart);
            String tail = files[k].substring(tailStart, chars.length);
            
            
            // System.out.println(number);
            // System.out.println(file.substring(tailStart, chars.length));
            // System.out.println();
            fileList[k] = new File(header, number, tail, k);
        }
        
        Arrays.sort(fileList, (f1, f2) -> {
            if (f1.header.equalsIgnoreCase(f2.header)) {
                if (Integer.parseInt(f1.number) == Integer.parseInt(f2.number)) {
                    return f1.index - f2.index;
                }
                return Integer.parseInt(f1.number) - Integer.parseInt(f2.number);
            }
            return f1.header.compareToIgnoreCase(f2.header);
        });
        
        String[] answer = new String[fileList.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fileList[i].getString();
        }
        return answer;
    }
    
    private String getHeader(String str) {
        char[] chars = str.toCharArray();
        
        for (int i = 0; i <= chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                numberStart = i;
                break;
            }
        }
        return str.substring(0, numberStart);
    }
    
    private String getNumber(String str) {
        char[] chars = str.toCharArray();
        
        tailStart = chars.length;
        for (int i = numberStart; i < chars.length; i++) {
            if (!Character.isDigit(chars[i])) {
                tailStart = i;
                break;
            }
        }
        return str.substring(numberStart, tailStart);
    }
    
    static class File {
        String header;
        String number;
        String tail;
        int index;
        
        public File(String header, String number, String tail, int index) {
            this.header = header;
            this.number = number;
            this.tail = tail;
            this.index = index;
        }
        
        public String getString() {
            return header + number + tail;
        }
    }
}