import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        
        int size = skill.length();
        
        int count = 0;
        
        outer:
        for (String mySkill : skill_trees) {
            int[] indexes = new int[size];
            indexes[size - 1] = findIndex(mySkill, skill.charAt(size - 1));
            
            for (int i = (size - 1) - 1; i >= 0; i--) {
                char target = skill.charAt(i);
                indexes[i] = findIndex(mySkill, target);
                if (indexes[i + 1] < findIndex(mySkill, target)) {
                    continue outer;
                }
            }
            // System.out.println(Arrays.toString(indexes));
            count++;
        }
        
        System.out.println(count);
        
        int answer = count;
        return answer;
    }
    
    private int findIndex(String str, char target) {
        for (int i = 0;  i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }
}