import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int MAX_N = 100;
    static int[] times = new int[1000];
    static int[][] arr = new int[MAX_N][2];

    static int N;
    static int max = Integer.MIN_VALUE;


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            for (int j = start; j < end; j++) {
                times[j]++;
            }
        }

        for (int i = 0; i < N; i++) {
            // 타임라인 하나씩 지우기
            int start = arr[i][0];
            int end = arr[i][1];
            for (int j = start; j < end; j++) {
                times[j]--;
            }

            // 지우고 나서 계산해보기
            int sum = 0;
            for (int j = 0; j < 1000; j++) {
                if (times[j] > 0) sum++;
            }
//            System.out.println(Arrays.toString(times));
            max = Math.max(max, sum);

            // 다시 타임라인 원상복구
            for (int j = start; j < end; j++) {
                times[j]++;
            }
        }

        System.out.println(max);

    }
}
