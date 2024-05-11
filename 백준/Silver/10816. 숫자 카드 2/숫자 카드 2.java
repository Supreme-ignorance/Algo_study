import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int K = Integer.parseInt(br.readLine());
        int[] targets = new int[K];
        tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) {
            targets[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();

        for (int target : targets) {
            int length = higherBound(target, numbers) - lowerBound(target, numbers);


            sb.append(length + " ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int value, int[] numbers) {
        int left = 0;
        int right = numbers.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (numbers[mid] >= value) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
    public static int higherBound(int value, int[] numbers) {
        int left = 0;
        int right = numbers.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (numbers[mid] <= value) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return right;
    }
}