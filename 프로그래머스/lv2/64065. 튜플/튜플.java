import java.util.*;

class Solution {
    
    List<Integer>[] numbers;
    
    public int[] solution(String s) {
        
        String target = s.substring(1, s.length() - 1);
        String[] tuples = target.split("},");
        // System.out.println(Arrays.toString(tuples));
        
        numbers = new List[tuples.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < tuples.length; i++) {
            if (i == tuples.length - 1) {
                String number = tuples[i].substring(1, tuples[i].length() - 1);
                splitNumber(i, number);
                continue;
            }
            String number = tuples[i].substring(1, tuples[i].length());
            splitNumber(i, number);
        }
        
        Arrays.sort(numbers, new Comparator<List<Integer>>() {
            public int compare(List nums1, List nums2) {
                return nums1.size() - nums2.size();
            }
        });
        
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                result.add(numbers[i].get(0));
                continue;
            }
            List<Integer> integers = numbers[i];
            integers.removeAll(result);
            result.addAll(integers);
        }
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    private void splitNumber(int index, String number) {
        String[] strings = number.split(",");
        for (String string : strings) {
            numbers[index].add(Integer.valueOf(string));
        }
    }
}