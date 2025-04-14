import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;

    static List<Integer> selected = new ArrayList<>();

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        comb(0, 1);
    }


    static void comb(int cur, int start) {
        if (cur == M) {
            for (int i : selected) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            selected.add(i);
            comb(cur + 1, i + 1);
            selected.remove(selected.size() - 1);
        }
    }

}
