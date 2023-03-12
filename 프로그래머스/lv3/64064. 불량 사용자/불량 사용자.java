import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;


class Solution {

    static Set<HashSet<Integer>> answer;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> candidate;

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        visited = new boolean[user_id.length];
        candidate = new ArrayList<>();
        for (int i = 0; i < banned_id.length; i++) {
            candidate.add(new ArrayList<>());
        }

        for (int i = 0; i < banned_id.length; i++) {
            for (int j = 0; j < user_id.length; j++) {
                if (checkId(banned_id[i], user_id[j])) {
                    candidate.get(i).add(j);
                }
            }
        }
        dfs(0, new HashSet<>(), user_id);
        return answer.size();
    }

    private void dfs(int idx, HashSet<Integer> set, String[] userId) {
        if (idx == candidate.size()) {
            answer.add(new HashSet<>(set));
            return;
        }

        for (int idIdx : candidate.get(idx)) {
            if (!visited[idIdx]) {
                visited[idIdx] = true;
                set.add(userId[idIdx].hashCode());
                dfs(idx + 1, set, userId);
                set.remove(userId[idIdx].hashCode());
                visited[idIdx] = false;
            }
        }
    }

    private boolean checkId(String banId, String userId) {
        if (banId.length() != userId.length()) {
            return false;
        }

        for (int i = 0; i < banId.length(); i++) {
            if (banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}