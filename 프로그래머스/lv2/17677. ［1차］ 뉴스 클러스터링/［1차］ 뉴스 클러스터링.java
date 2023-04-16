import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        return usado(str1.toLowerCase(), str2.toLowerCase());
    }
    
    public int usado(String str1, String str2){
        List<String> crossSet = new ArrayList<>();
        List<String> unionSet = new ArrayList<>();
        
        //str을 두 글자씩 끊는다
        LinkedList<String> sep1 =  separate(str1);
        LinkedList<String> sep2 =  separate(str2);
        
        for(String s : sep1){
            if(sep2.remove(s)){
                crossSet.add(s);
            }
            unionSet.add(s);
        }
        
        for(String s : sep2){
            unionSet.add(s);
        }
        
        if(unionSet.size() == 0){
            return 1*65536;
        }
        
        
        return (int) (((double) crossSet.size()/(double) unionSet.size())*65536);        
    }
    
    private LinkedList<String> separate(String str){
        LinkedList<String> strSep = new LinkedList<>();
        label:
        for(int i=0; i<str.length()-1; i++){
            String substr = str.substring(i, i+2);
            for(int j=0; j<2; j++){
                if(!Character.isAlphabetic(substr.charAt(j))){
                    continue label;
                }
            }
            strSep.add(substr);
        }
        return strSep;
    }
}