import java.util.*;

class Solution {
    
    String[][] table;
    int rowLength;
    int columnLength;
    boolean[] visited;
    boolean[] done;
    Set<String> set;
    Set<String> candidate;
    
    
    int result;
    
    public int solution(String[][] relation) {
        
        table = relation;
        rowLength = relation.length;
        columnLength = relation[0].length;
        visited = new boolean[columnLength];
        done = new boolean[columnLength];
        candidate = new HashSet<>();
        
        subSet(0);
        // System.out.println(candidate.size());
        
        int answer = candidate.size();
        return answer;
    }
    
    private void subSet(int index) {
        if (index == columnLength) { //기저 조건
            List<Integer> list = new ArrayList<>();
            String key = "";
            for (int i = 0; i < columnLength; i++) {
                if (!visited[i]) {
                    key += (i + "");
                    list.add(i);
                }
            }
            // for (int number : list) {
            //     if (done[number]) {
            //         return;
            //     }
            // }
            cal(list, key);
            return;
        }
        
        visited[index] = true;
        subSet(index + 1);
        visited[index] = false;
        subSet(index + 1);
    }
    
    private void cal(List<Integer> list, String key) {
        if (list.isEmpty()) {
            return;
        }
        
        for (String s : candidate) {
            int count = 0;
            for (int i = 0; i < key.length(); i++) {
                String sub = (key.charAt(i) + "");
                if (s.contains(sub)) {
                    count++;
                }
            }
            if (count == s.length()) {
                return;
            }
        }
        
        set = new HashSet<>();
        
        for (int r = 0; r < rowLength; r++) {
            String temp = "";
            for (int c = 0; c < list.size(); c++) {
                int column = list.get(c);
                temp += table[r][column];
            }
            set.add(temp);
        }
        
        if (set.size() == rowLength) {
            // for (int num : list) {
            //     done[num] = true;
            // }
            candidate.add(key);
        }
    }
}