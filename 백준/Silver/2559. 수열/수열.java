import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int K = kb.nextInt();

        int[] numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = kb.nextInt();
        }
        // 누적합 배열
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[i - K]);
        }
        System.out.println(max);
    }
}
