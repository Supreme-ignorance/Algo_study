import java.util.*;

class Solution {
    static List<String>[] idCollection;
    static List<String[]> result;
    static int count = 0;
    public int solution(String[] user_id, String[] banned_id) {
        int banLen = banned_id.length;
        int userLen = user_id.length;
        
        idCollection = new ArrayList[banLen];
        result = new ArrayList<String[]>();
        
        for (int i = 0; i < banLen; i++) {
            idCollection[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < banLen; i++) {
            String currBan = banned_id[i];   
            for (int j = 0; j < userLen; j++) {
                String currUser = user_id[j];
                if (compareLength(currBan, currUser)) {
                    if (possible(currBan, currUser)) {
                        idCollection[i].add(currUser);
                    }
                }
            }
        }
        
        combination(0, banLen, new ArrayList<String>());
        // for (int i = 0; i < result.size(); i++) {
        //     System.out.println(Arrays.toString(result.get(i)));
        // }
        return count;
    }
    
    private static boolean compareLength(String currBan, String currUser) {
        if (currBan.length() != currUser.length()) {
            return false;
        }
        return true;
    }
    
    private static boolean possible(String currBan, String currUser) {
        boolean flag = true;
        for (int i = 0; i < currBan.length(); i++) {
            char currB = currBan.charAt(i);
            char currU = currUser.charAt(i);
            if (currB != '*' && currB != currU) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    
    private static void combination(int banIndex, int banLen, List<String> pick) {
        if (banIndex == banLen) {
            Set<String> deduplication = new HashSet<>();
            for (int i = 0; i < pick.size(); i++) {
                deduplication.add(pick.get(i));
            }
            
            if (deduplication.size() == banLen) {
                if (result.size() == 0) {
                    result.add(deduplication.toArray(new String[deduplication.size()]));
                    count++;
                } else {
                    boolean newOne = true;
                    for (int i = 0; i < result.size(); i++) {
                        String[] temp = result.get(i);
                        boolean isSame = true;
                        for (int j = 0; j < temp.length; j++) {
                            if (!deduplication.contains(temp[j])) {
                                isSame = false;
                            } 
                        }
                        if (isSame) {
                            newOne = false;
                            break;
                        }
                        
                    }
                    if (newOne) {
                        result.add(deduplication.toArray(new String[deduplication.size()]));
                        count++;
                    }
                }
            }
            return;
        }
        
        for (int i = 0; i < idCollection[banIndex].size(); i++) {
            pick.add(idCollection[banIndex].get(i));
            banIndex += 1;
            combination(banIndex, banLen, pick);
            banIndex -= 1;
            pick.remove(pick.size() - 1);
        }
    }
}