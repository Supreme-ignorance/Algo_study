import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M;
    static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        recur(1, 0);
    }

    static void recur(int number, int total) {
        if (number == N + 1) {
            if (total == M) {
                for (int i : selected) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            return;
        }

        selected.add(number);
        recur(number + 1, total + 1);
        selected.remove(selected.size() - 1);
        recur(number + 1, total);

    }
}
