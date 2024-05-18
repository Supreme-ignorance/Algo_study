import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(token.nextToken());
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < N; i++) {
            right += numbers[i];
            left = Math.max(left, numbers[i]);
        }



        while (left <= right) {
            int mid = (left + right) / 2;
            int count = divideNumbers(numbers, mid);
            if (count <= M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    static int divideNumbers(int[] numbers, int limit) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (sum + numbers[i] > limit) {
                sum = 0;
                count++;
            }
            sum += numbers[i];
        }

        if (sum != 0) count++;
        return count;
    }
}