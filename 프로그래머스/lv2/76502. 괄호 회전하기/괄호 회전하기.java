import java.util.*;

class Solution {
    static Deque<Character> stk = new ArrayDeque<>();
    
    public int solution(String s) {
        int answer = 0;
        
        
        int[] cnt = new int[6];
        char[] charList = s.toCharArray();
        
        LinkedList<Character> ll = new LinkedList<>();
        for(int i=0; i<s.length(); i++){
            ll.add(s.charAt(i));
            if(s.charAt(i)=='['){
                cnt[0]++;
            }else if(s.charAt(i)==']'){
                cnt[1]++;
            }else if(s.charAt(i)=='{'){
                cnt[2]++;
            }else if(s.charAt(i)=='}'){
                cnt[3]++;
            }else if(s.charAt(i)=='('){
                cnt[4]++;
            }else{
                cnt[5]++;
            }
        }
        if(cnt[0]!=cnt[1] || cnt[2]!=cnt[3] || cnt[4]!=cnt[5]){
            return 0;
        }
        
        int turn = 0;
        while(turn<s.length()){
            if(check(ll)) answer++;
            char temp = ll.poll();
            ll.add(temp);
            turn++;
        }
        
        return answer;
    }
    
    public boolean check(LinkedList<Character> list){
        for(int i=0; i<list.size(); i++){
            if(list.get(i)==']'){
                if(stk.isEmpty() || stk.peek()!='[') return false;
                stk.pop();
            }else if(list.get(i)=='}'){
                if(stk.isEmpty() || stk.peek()!='{') return false;
                stk.pop();
            }else if(list.get(i)==')'){
                if(stk.isEmpty() || stk.peek()!='(') return false;
                stk.pop();
            }else{
                stk.push(list.get(i));
            }
        }
        return true;
    }
    
}