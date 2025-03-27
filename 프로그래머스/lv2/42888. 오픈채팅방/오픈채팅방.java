import java.util.*;

class Solution {
    
    Map<String, String> map;
    List<String> records = new ArrayList<>();
    
    public String[] solution(String[] record) {
        
        map = new HashMap<>();
        
        for (String s : record) {
            String[] infos = s.split(" ");
            String command = infos[0];
            if (command.equals("Leave")) {
                String userId = infos[1];
                leave(command, userId);
            }
            else {
                String userId = infos[1];
                String nickName = infos[2];
                execute(command, userId, nickName);
            }            
        }
        
        String[] answer = new String[records.size()];
        for (int i = 0; i < records.size(); i++) {
            String[] split = records.get(i).split(" ");
            if (split[0].equals("E")) {
                String content = map.get(split[1]) + "님이 들어왔습니다.";
                answer[i] = content;
                continue;
            }
            if (split[0].equals("L")) {
                String content = map.get(split[1]) + "님이 나갔습니다.";
                answer[i] = content;
            }
        }
        
        // String[] answer = {};
        return answer;
    }
    
    private void execute(String command, String userId, String nickName) {
        if (command.equals("Enter")) {
            map.put(userId, nickName);
            records.add("E " + userId);
            return;
        }
        if (command.equals("Change")) {
            map.put(userId, nickName);
            return;
        }
        
    }
    private void leave(String command, String userId) {
        records.add("L " + userId);
    }
}