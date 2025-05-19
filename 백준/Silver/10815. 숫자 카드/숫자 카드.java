import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        int M = kb.nextInt();
        for (int i = 0; i < M; i++) {
            int target = kb.nextInt();

            int start = 0;
            int end = arr.length - 1;
            int answer = 0;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    answer = 1;
                    break;
                }
                else if (arr[mid] < target) {
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            sb.append(answer).append(" ");
        }

        System.out.println(sb.toString());
    }
}
