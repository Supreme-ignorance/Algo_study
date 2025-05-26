import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int W;
    static int H;
    static int[] arr;
    static int[] prefixMax;
    static int[] suffixMax;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        H = kb.nextInt();
        W = kb.nextInt();
        arr = new int[W + 2];
        for (int i = 1; i <= W; i++) {
            arr[i] = kb.nextInt();
        }

        prefixMax = new int[W + 2];
        suffixMax = new int[W + 2];
        for (int i = 1; i <= W; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        for (int i = W; i >= 1; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }
//        System.out.println(Arrays.toString(prefixMax));
//        System.out.println(Arrays.toString(suffixMax));

        int sum = 0;
        for (int i = 1; i <= W; i++) {
            sum += (Math.min(prefixMax[i], suffixMax[i]) - arr[i]);
        }
        System.out.println(sum);
    }
}
