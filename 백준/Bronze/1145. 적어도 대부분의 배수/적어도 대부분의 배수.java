import java.util.Scanner;

public class Main {

    static int[] arr = new int[5];

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            arr[i] = kb.nextInt();
        }

        int result = -1;

        // O(1_000_000 * 5)
        for (int i = 1; i <= 100 * 100 * 100; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (i % arr[j] == 0) cnt++;
            }
            if (cnt >= 3) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
