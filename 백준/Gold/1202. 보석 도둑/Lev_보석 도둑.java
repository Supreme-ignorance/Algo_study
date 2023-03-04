import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static PriorityQueue<Jewel> pq = new PriorityQueue<>(((o1, o2) -> o2.value - o1.value));

    public static class Jewel {
        int weight;
        int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); // 보석의 총 개수
        int K = Integer.parseInt(tokenizer.nextToken()); // 가방의 무게

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());

            jewels[i] = new Jewel(weight, value);
        } //보석 배열 초기화

        Arrays.sort(jewels, new Comparator<Jewel>() { //보석 배열 정렬
            @Override
            public int compare(Jewel o1, Jewel o2) { // 값어치의 내림차순으로 정렬
                return o1.weight - o2.weight;
            }
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            int bagWeight = Integer.parseInt(br.readLine());
            bags[i] = bagWeight;
        }
        Arrays.sort(bags); //오름차순으로 가방을 정렬

        long sum = 0;
        int currentIndex = 0;
        for (int i = 0; i < K; i++) {
            int maxWeight = bags[i];
            while (currentIndex < N && jewels[currentIndex].weight <= maxWeight) {
                Jewel jewel = jewels[currentIndex];
                pq.add(jewel);
                currentIndex++;
            }
            if (!pq.isEmpty()) {
                sum += pq.poll().value;
            }
        }

        System.out.println(sum);
    }
}