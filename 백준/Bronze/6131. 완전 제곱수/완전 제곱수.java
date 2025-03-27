import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int N = kb.nextInt();

        int cnt = 0;
        // O(500*500)
        for (int b = 1; b <= 500; b++) {
            for (int a = b; a <= 500; a++) {
                if (a * a == b * b + N) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
