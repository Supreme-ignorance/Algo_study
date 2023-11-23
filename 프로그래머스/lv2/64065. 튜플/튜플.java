import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        s = s.substring(1, s.length() - 1);
        // System.out.println(s);
        Deque<Character> stack = new ArrayDeque<>();
        
        //글자 조합 저장소
        StringBuilder sb = new StringBuilder();
        
        //String -> List<List<>> 저장소
        List<List<Integer>> records = new ArrayList<>();
        //각 List 담을 저장소
        List<Integer> record = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{') {
                record = new ArrayList<>();
                stack.push('{');
                continue;
            }
            if (s.charAt(i) == '}') {
                // System.out.println("} 전 : " + sb.toString());
                record.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                
                records.add(record);
                stack.pop();
                continue;
            }
            // { 가 들어있다면
            if (!stack.isEmpty()) {
                //쉼표라면
                if (s.charAt(i) == ',') {
                    //쉼표 전까지의 sb를 record에 넣는다.
                    record.add(Integer.parseInt(sb.toString()));
                    // StringBuilder 초기화
                    sb = new StringBuilder();
                }
                else {
                    sb.append(s.charAt(i));
                }
            }
            // System.out.println(records);
        }

        //문자열을 배열로 올바르게 만든 뒤 다시 정렬해주어야 한다. 사이즈로 정렬
        records.sort((a, b) -> a.size() - b.size());
        //정답 순서를 담을 리스트
        List<Integer> result = new ArrayList<>();
        
        //이중 포문을 돌면서
        for (List<Integer> r : records) {
            for (Integer i : r) {
                //만약 정답 순서에 없다면 넣어준다.
                if (!result.contains(i)) {
                    result.add(i);
                }
            }
        }
        // System.out.println(result);
        int [] temp = result.stream().mapToInt(Integer::intValue).toArray();
        int[] answer = temp;
        return answer;
    }
}