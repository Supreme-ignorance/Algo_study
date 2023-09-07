import java.util.*;

class Solution {
    
    String[][] tickets;
    List<String> answers;
    int limit;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        boolean[] visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        limit = tickets.length;
        
        dfs("ICN", "ICN", 0, visited);
        Collections.sort(answers);
        
        String[] answer = answers.get(0).split(" ");
        return answer;
    }
    
    public void dfs(String current, String answer, int count, boolean[] visited) {
        if (count == limit) { //기저조건: 모든 티켓을 다 사용했다면
            answers.add(answer); //answers에 추가
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) { //current와 같지만 들리지 않은 공항을 찾아
                visited[i] = true; //해당 티켓 사용처리
                dfs(tickets[i][1], answer + " " + tickets[i][1], count + 1, visited); 
                //answer에 해당 티켓 도착지를 붙이고, 도착지를 출발지로 깊이우선탐색
                visited[i] = false;
            }
        }
    }
}