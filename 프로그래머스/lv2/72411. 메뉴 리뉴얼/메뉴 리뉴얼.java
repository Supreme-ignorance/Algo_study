import java.util.*;

class Solution {
    
    private Map<String, Integer>[] maps;
    
    public String[] solution(String[] orders, int[] course) {
        
        maps = new Map[10 + 1];
        for (int i = 0; i < maps.length; i++) {
            maps[i] = new HashMap<String, Integer>();
        }
        
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr); //정렬
            
            for (int limit : course) {
                char[] chars = new char[limit];
                comb(0, 0, limit, arr, chars);
            }
        }
        
        
        List<String>[] strings = new List[10 + 1];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = new ArrayList<>();
        }
        int[] maxes = new int[10 + 1];
        
                
        for (int i = 2; i <= 10; i++) {
            Map<String, Integer> map = maps[i];
            for (String key : map.keySet()) {
                int count = map.get(key);
                if (count < 2) {
                    continue;
                }
                if (maxes[i] == count) {
                    strings[i].add(key);
                    continue;
                }
                if (maxes[i] < count) {
                    maxes[i] = count;
                    strings[i] = new ArrayList<>();
                    strings[i].add(key);
                }

            }
        }
        
        List<String> arr = new ArrayList<>();
        for (int i = 2; i <= 10; i++) {
            if (!strings[i].isEmpty()) {
                arr.addAll(strings[i]);
            }
        }
        
        String[] answer = new String[arr.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = arr.get(i);
        }
         
        Arrays.sort(answer);
        return answer;
    }
    
    private void comb(int depth, int start, int limit, char[] order, char[] chars) {
        if (depth == limit) { //기저조건
            String result = convertToString(chars);
            maps[result.length()].put(result, maps[result.length()].getOrDefault(result, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length; i++) {
            chars[depth] = order[i];
            comb(depth + 1, i + 1, limit, order, chars);
        }
        
    }
    
    private String convertToString(char[] chars) {
        String temp = "";
        for (char ch : chars) {
            temp += ch;
        }
        return temp;
    }
}