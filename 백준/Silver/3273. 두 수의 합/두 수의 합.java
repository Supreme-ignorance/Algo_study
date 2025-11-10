import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] arr;
    static int X;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        X = kb.nextInt();

        int s = 0;
        int e = N - 1;
        while (s < e) {
            if (arr[s] + arr[e] == X) {
                ans++;
                s++;
                e--;
            }
            else if (arr[s] + arr[e] < X) {
                s++;
            }
            else { // arr[s] + arr[e] > X
                e--;
            }
        }
        System.out.println(ans);
    }
}
