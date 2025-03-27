import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        int cnt = 0;
        // n^3 어차피 최대 100 이라 100 * 100 * 100 은 1_000_000_000
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j <= 100; j++) {
                for (int k = 1; k <= 100; k++) {

                    // 남는 사탕이 없어야 하므로
                    if (i + j + k != N) continue;

                    // i가 j보다 2개 이상 많고, k가 홀수개를 받으면 안된다.
                    if (i >= j + 2 && k % 2 == 0) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
