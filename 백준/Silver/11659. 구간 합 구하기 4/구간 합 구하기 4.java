import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] numbers;
    static int[] prefixSum;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = kb.nextInt();
        }

        // 누적합 배열
        prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + numbers[i];
        }

        for (int i = 0; i < M; i++) {
            int startIdx = kb.nextInt();
            int endIdx = kb.nextInt();

            System.out.println(prefixSum[endIdx] - prefixSum[startIdx - 1]);
        }
    }
}
