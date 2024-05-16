import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());

            tokenizer = new StringTokenizer(br.readLine(), " ");
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(tokenizer.nextToken());
            }// Setting

            Arrays.sort(numbers);

            int minAbs = Integer.MAX_VALUE;
            int count = 0;

            int leftIdx = 0;
            int rightIdx = N - 1;
            while (leftIdx < rightIdx) {
                int sum = numbers[leftIdx] + numbers[rightIdx];
                int absValue = Math.abs(sum - K);
                if (absValue == minAbs) {
                    count++;
                }
                else if (absValue < minAbs) {
                    minAbs = absValue;
                    count = 1;
                }

                if (sum <= K) {
                    leftIdx++;

                }
                else {
                    rightIdx--;
                }
//                else if (sum < K) {
//                  leftIdx++;
//                }
//                else { // 같다면
//                    int leftAbsValue = Math.abs(numbers[leftIdx] - numbers[leftIdx + 1]);
//                    int rightAbsValue = Math.abs(numbers[rightIdx] - numbers[rightIdx - 1]);
//                    if (leftAbsValue <= rightAbsValue) {
//                        leftIdx++;
//                    }
//                    else {
//                        rightIdx++;
//                    }
//                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}