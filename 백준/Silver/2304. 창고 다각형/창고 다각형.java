import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr = new int[1000 + 2];
    static int[] prefixMax = new int[1000 + 2];
    static int[] suffixMax = new int[1000 + 2];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            int idx = kb.nextInt();
            int height = kb.nextInt();
            arr[idx] = height;
        }

        for (int i = 1; i < arr.length; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }
        for (int i = arr.length - 1 - 1; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.min(prefixMax[i], suffixMax[i]);
        }
        System.out.println(sum);
    }
}
