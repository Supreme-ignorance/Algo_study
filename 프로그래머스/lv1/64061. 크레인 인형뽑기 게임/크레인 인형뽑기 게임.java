import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int c = 0; c < board[0].length; c++) {
            map.putIfAbsent(c, new ArrayDeque<>());
            for (int r = board.length - 1; r >= 0; r--) {
                if (board[r][c] != 0) {
                    map.get(c).push(board[r][c]);
                }
            }
        }
        
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        for (int move : moves) {
            // 안에 무엇이 있다면
            if (!map.get(move - 1).isEmpty()) {
                int target = map.get(move - 1).pop();
                if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    count += 2;
                }
                else {
                    stack.push(target);
                }
            }
        }
        
        int answer = count;
        return answer;
    }
}