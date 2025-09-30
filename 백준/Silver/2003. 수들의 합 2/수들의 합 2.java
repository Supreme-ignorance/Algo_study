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
        while (s < N) {
            while (e < N && sum < M) {
                sum += arr[e];
                e++;
            }
            if (sum == M) ans++;
            sum -= arr[s];
            s++;
        }

        System.out.println(ans);
    }
}
