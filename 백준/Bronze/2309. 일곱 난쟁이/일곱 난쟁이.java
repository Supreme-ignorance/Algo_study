import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int N = 9;
    static final int TARGET = 100;
    static int[] arr = new int[9];
    static List<Integer> picked = new ArrayList<>();
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        for (int i = 0; i < N; i++) {
            arr[i] = kb.nextInt();
        }
        comb(0);

        Collections.sort(answer);
        for (int i : answer) {
            System.out.println(i);
        }
    }

    static void comb(int start) {
        if (picked.size() == 7) {
            int sum = 0;
            for (int i = 0; i < picked.size(); i++) {
                sum += picked.get(i);
            }

            if (sum == TARGET) {
                answer = new ArrayList<>();
                for (int i = 0; i < picked.size(); i++) {
                    answer.add(picked.get(i));
                }
            }
            return;
        }

        for (int i = start; i < N; i++) {
            picked.add(arr[i]);
            comb(i + 1);
            picked.remove(picked.size() - 1);
        }
    }
}
