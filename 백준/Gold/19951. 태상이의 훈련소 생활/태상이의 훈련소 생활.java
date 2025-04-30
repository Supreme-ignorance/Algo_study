import java.util.Arrays;
import java.util.Scanner;

/**
 * 모두 Update 한 다음 마지막에 Get Query
 * 점 -> 구간을 반대로 치환해서 구간 -> 점으로 만드는 기법
 */
public class Main {

    static int N;
    static int M;

    static int[] arr;
    static int[] check;
    static int[] prefixSum;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        arr = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            arr[i] = kb.nextInt();
        }

        check = new int[N + 2];
        for (int i = 0; i < M; i++) { // Update
            int start = kb.nextInt();
            int end = kb.nextInt();
            int value = kb.nextInt();

            check[start] += value;
            check[end + 1] -= value;
        }

//        prefixSum = new int[N + 2];
//        for (int i = 1; i < prefixSum.length; i++) {
//            prefixSum[i] = prefixSum[i - 1] + check[i];
//        }
        for (int i = 1; i < check.length; i++) {
            check[i] = check[i - 1] + check[i];
        }

//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(check));

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + check[i] + " ");
        }
    }
}
