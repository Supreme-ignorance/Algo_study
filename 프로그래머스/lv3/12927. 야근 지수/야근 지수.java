import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        Arrays.sort(works);
        while(n>0){
            int pointer = works.length-1;
            works[pointer]--;
            while(pointer>0 && works[pointer]<works[pointer-1]){
                swap(works, pointer, pointer-1);
                pointer--;
            }       
            if(works[works.length-1]==0) break;
            n--;
        }
        System.out.println(Arrays.toString(works));
        for(int i=0; i<works.length; i++){
            answer += works[i]*works[i];
        }
        
        return answer;
    }
    
    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}