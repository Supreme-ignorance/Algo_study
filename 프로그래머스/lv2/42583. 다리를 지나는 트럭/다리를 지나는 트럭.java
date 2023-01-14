import java.util.*;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer[]> q = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
        for (int i : truck_weights) {
            trucks.offer(i);
        }
        int time = 1;
        int currentWeight = trucks.peek();
        q.offer(new Integer[]{trucks.poll(), 1});
        while (!trucks.isEmpty() || !q.isEmpty()) {
            time++;
            for (Integer[] arr : q) {
                arr[1]++;
            }
            if (q.peek()[1] > bridge_length) {
                    currentWeight -= q.poll()[0];
            }
            if (!trucks.isEmpty() && currentWeight + trucks.peek() <= weight) {
                    currentWeight += trucks.peek();
                    q.offer(new Integer[]{trucks.poll(), 1});
            }
        }
        return time;
    }
}