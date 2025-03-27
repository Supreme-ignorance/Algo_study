import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt(); // 트럭의 개수
        int bridgeLength = kb.nextInt(); // 다리의 길이
        int bridgeWeight = kb.nextInt(); // 다리가 견딜 수 있는 무게

        Queue<Truck> waitQueue = new ArrayDeque<>();
        Queue<Truck> bridgeQueue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            waitQueue.add(new Truck(kb.nextInt()));
        }

        int currentWeight = 0;
        int time = 0;
        while (!waitQueue.isEmpty() || !bridgeQueue.isEmpty()) {
            int queueSize = bridgeQueue.size();
            for (int i = 0; i < queueSize; i++) { //브릿지 큐는 브릿지 큐에 들어있는 개수만큼 반복문을 돌려, 각 트럭의 현재 위치를 갱신한다.
                Truck truck = bridgeQueue.poll(); //트럭을 꺼낸다.
                truck.currentLocation++; // 트럭의 현재 위치를 하나 올려준다.
                if (truck.currentLocation <= bridgeLength) { // 만약 트럭의 현재 위치가 다리 길이보다 작으면 다시 큐에 넣어준다.
                    bridgeQueue.add(truck);
                }
                else {
                    currentWeight -= truck.weight;
                }
            }

            if (!waitQueue.isEmpty() && currentWeight + waitQueue.peek().weight <= bridgeWeight) { //만약 대기큐의 첫번재 트럭의 무게와 현재 (다리) 무게가 최대 무게보다 작다면
                Truck truck = waitQueue.poll(); // 대기 큐에서 트럭을 꺼낸 뒤
                truck.currentLocation++; // 위치를 옮겨주고
                currentWeight += truck.weight;
                bridgeQueue.add(truck); // 다리 큐에 넣어준다.
            }


            time++;
        }

        System.out.println(time);
    }

    static class Truck {

        int weight;
        int currentLocation = 0;

        public Truck(int weight) {
            this.weight = weight;
        }
    }
}