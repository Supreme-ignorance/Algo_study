import java.util.Scanner;

public class Main {

    static int N = 10;
    static int[] arr = new int[N];
    static int[] answer = new int[N];
    static int count;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }

        recur(0, 0, 0);
        System.out.println(count);
    }

    static void recur(int cnt, int before, int sum) {
        if (cnt == N) {
            int score = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == answer[i]) score++;
            }
            if (score >= 5) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (i == before) {
                if (sum + 1 < 3) {
                    answer[cnt] = i;
                    recur(cnt + 1, i, sum + 1);
                }
            }
            else {
                answer[cnt] = i;
                recur(cnt + 1, i, 1);
            }
        }
    }
}
