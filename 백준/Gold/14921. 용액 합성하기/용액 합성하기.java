import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            numbers[i] = num;
        }

        int leftIndex = 0;
        int rightIndex = N - 1;

        int abs = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while (leftIndex < rightIndex) {
            int sum = numbers[leftIndex] + numbers[rightIndex];

            if (Math.abs(sum) < abs) {
                abs = Math.abs(sum);
                result = sum;
            }

            if (sum >= 0) {
                rightIndex--;
            }
            else {
                leftIndex++;
            }
        }
        System.out.println(result);
    }
}