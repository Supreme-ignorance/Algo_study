import java.util.Scanner;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        recur(1, "2");
        recur(1, "3");
        recur(1, "5");
        recur(1, "7");
    }

    static void recur(int cnt, String current) {
        if (cnt == N) {
            System.out.println(current);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            int next = Integer.parseInt(current) * 10 + i;
            if (isPrime(next)) {
                recur(cnt + 1, String.valueOf(next));
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
