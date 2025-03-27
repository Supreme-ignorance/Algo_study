import java.util.*;

class Solution {
    
    String[] titles;
    public String solution(String m, String[] musicinfos) {
        
        List<String> origin = toList(m);
        
        titles = new String[musicinfos.length];

        String answer = "(None)";
        int maxSize = 0;
        
        for (int i = 0; i < musicinfos.length; i++) {
            List<String> melody = getMelody(musicinfos[i], i);
            if (origin.size() > melody.size()) {
                continue;
            }
            for (int j = 0; j <= melody.size() - origin.size(); j++) {
                int count = 0;
                for (int k = 0; k < origin.size(); k++) {
                    if (!melody.get(j + k).equals(origin.get(k))) {
                        break;
                    }
                    count++;
                }
                if (count == origin.size()) {
                    if (melody.size() > maxSize) {
                        answer = titles[i];
                        maxSize = melody.size();
                    }
                }
            }
        }

        return answer;
    }
    
//     private int getHash(String str, int exponent) {
//         int hashSum = 0;
//         int power = 1;
        
//         for (int i = 0; i < str.length(); i++) {
//             hashSum += hash(str.charAt(str.length() - 1 - i), power);
//             power *= exponent;
//         }
//         return hashSum;
//     }
    
//     private int hash(int value, int power) {
//         return value * power;
//     }
    
    private List<String> getMelody(String musicInfo, int index) {
        String[] info = musicInfo.split(",");
        String startTime = info[0];
        String[] startTimes = startTime.split(":");
        
        String endTime = info[1];
        String[] endTimes = endTime.split(":");
        
        int hour = Integer.parseInt(endTimes[0]) - Integer.parseInt(startTimes[0]);
        int minute = Integer.parseInt(endTimes[1]) - Integer.parseInt(startTimes[1]);
        int sum = (hour * 60) + minute;
        
        String title = info[2];
        titles[index] = title;
        
        String melody = info[3];
        List<String> melodyList = toList(melody);
        
        List<String> result = new ArrayList<>();
        if (sum >= melodyList.size()) {
            int share = sum / melodyList.size();
            int rest = sum % melodyList.size();
            
            for (int i = 0; i < share; i++) {
                result.addAll(melodyList);
            }
            for (int i = 0; i < rest; i++) {
                result.add(melodyList.get(i));
            }
        }
        else { //길이가 더 짧다면
            for (int i = 0; i < sum; i++) {
                result.add(melodyList.get(i));
            }
        }
        return result;
    }
    
    private List<String> toList(String melody) {
        List<String> melodyList = new ArrayList<>();
        for (int i = 0; i < melody.length(); i++) {
            if (melody.charAt(i) == '#') {
                int last = melodyList.size() - 1;
                String result = melodyList.get(last) + "#";
                melodyList.remove(last);
                melodyList.add(result);
            }
            else {
                melodyList.add(melody.charAt(i) + "");
            }
        }
        return melodyList;
    }
}