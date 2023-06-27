import java.util.*;

class Solution {
    
    List<String>[] lists;
    List<Set<String>> sets;
    Set<String> currentSet;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        lists = new List[banned_id.length];
        sets = new ArrayList<>();
        
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < banned_id.length; i++) {
            for (String user : user_id) {
                if (banned_id[i].length() != user.length()) {//길이가 다르면
                    continue;
                }
                
                boolean flag = true;
                for (int j = 0; j < banned_id[i].length(); j++) {
                    if (banned_id[i].charAt(j) != user.charAt(j)) {
                        if (banned_id[i].charAt(j) != '*') {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    lists[i].add(user);
                }
            }
        }
        
        getResult(0);
        System.out.println(sets.size());
        
        int answer = 0;
        return answer;
    }
    
    private void getResult(int depth) {
        if (depth == lists.length) {
            
            
            for (Set<String> set : sets) {
                if (!set.equals(currentSet)) {
                    sets.add(currentSet);
                }
            }
            return;
        }

        List<String> list = lists[depth];
        for (int i = 0; i < list.size(); i++) {
            if (depth == 0) {
                currentSet = new HashSet<>();
            }
            if (!currentSet.contains(list.get(i))) {
                currentSet.add(list.get(i));
                System.out.println(currentSet);
                getResult(depth + 1);               
            }
            return;
        }
    }
}