import java.util.*;
class Solution {
    
    public class Node{
        Node head;
        Node tail;
        int num;
        
        public Node(Node head, Node tail, int num) {
            this.head = head;
            this.tail = tail;
            this.num = num;
        }
    }
    
    Deque<Integer> queue;
    
    public int[] solution(String[] operations) {
        queue = new ArrayDeque<>();
        Stack<Integer> temp = new Stack<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] currCmd = operations[i].split(" ");
            String op = currCmd[0];
            int num = Integer.valueOf(currCmd[1]);
            
            if (op.equals("D") && num == -1 && !queue.isEmpty()) {
                queue.pollLast();
            } else if (op.equals("D") && num == 1 && !queue.isEmpty()) {
                queue.pollFirst();
            } else if (op.equals("I")) {
                if (queue.isEmpty()) queue.add(num);
                else if (!queue.isEmpty()) {
                    while (!queue.isEmpty() && queue.peek() >= num) {
                        temp.push(queue.pollFirst());
                    }
                    queue.addFirst(num);
                    while (!temp.isEmpty()) {
                        queue.addFirst(temp.pop());
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        if (queue.isEmpty()) answer = new int[] {0, 0};
        else if (queue.size() == 1) answer = new int[] {queue.peek(), queue.peek()};
        else answer = new int[] {queue.pollFirst(), queue.pollLast()};
        return answer;
    }
}