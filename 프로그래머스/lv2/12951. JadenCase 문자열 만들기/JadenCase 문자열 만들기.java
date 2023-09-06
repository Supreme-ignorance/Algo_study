class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.toLowerCase().split("");
        boolean isTrue = true;
        
        for(String i : arr){
            answer += isTrue ? i.toUpperCase() : i;
            isTrue = i.equals(" ") ? true : false;
        }
        return answer;
    }
}