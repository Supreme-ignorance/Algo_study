import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();
        int[] answer;
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(1, s.length()-1));
        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i)=='{') {
                sb.insert(i, " ");
                i++;
            }
        }
        String[] tupleList = sb.toString().split(", ");
        answer = new int[tupleList.length];
        Arrays.sort(tupleList, (String s1, String s2) -> s1.length() - s2.length());
        label:
        for(int i=0; i<tupleList.length; i++){
            String[] temp = tupleList[i].substring(1, tupleList[i].length()-1).split(",");
            for(String num : temp){
                int prevSize = set.size();
                set.add(num);
                if(prevSize != set.size()){
                    answer[i] = Integer.parseInt(num);
                    continue label;
                }
            }
        }
        return answer;
    }
}