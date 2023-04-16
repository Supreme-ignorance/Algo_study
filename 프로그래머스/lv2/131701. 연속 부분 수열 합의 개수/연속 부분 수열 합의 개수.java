import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(int[] elements) {
        int[] circularList = new int[elements.length*2];
        
        for(int i=0; i<2; i++){
            for(int j=0; j<elements.length; j++){
                circularList[i*elements.length+j] = elements[j];
            }
        }
        
        for(int i=1; i<=elements.length; i++){
           getSum(circularList, i);
        }
        return set.size();
    }
    
    public void getSum(int[] circularList, int windowSize){
        int left = 0;
        int right = windowSize-1;
        int init = 0;
        for(int i=0; i<windowSize; i++){
            init += circularList[i];
        }
        set.add(init);
        while(right<circularList.length-1){
            init -= circularList[left++];
            init += circularList[++right];
            set.add(init);
        }
    }
}