import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] arr;

    static int ans = 0;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        int s = 0;
        int e = 0;
        int sum = 0;
        while (true) {
            if (sum >= M) {
                if (sum == M) ans++;
                sum -= arr[s];
                s++;
            }
            else {
                if (e == N) break;
                sum += arr[e];
                e++;
            }
        }
        System.out.println(ans);
    }
}
