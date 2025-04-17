import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static String[] arr;

    static List<Integer> selected = new ArrayList<>();

    static int min = Integer.MAX_VALUE;
    static int playMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        M = kb.nextInt();

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            String model = kb.next();
            arr[i] = kb.next();

        }

        recur(0, 0);
        System.out.println(playMax == 0 ? -1 : min);

    }

    static void recur(int cur, int cnt) {
        if (cur == N) {
            String available = "";
            for (int i = 0; i < M; i++) {
                boolean flag = false;
                for (int j = 0; j < selected.size(); j++) {
                    if (arr[selected.get(j)].charAt(i) == 'Y') {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    available += "Y";
                }
                else {
                    available += "N";
                }
            }
            int count = 0;
            for (int i = 0; i < M; i++) {
                if (available.charAt(i) == 'Y') count++;
            }
            if (count >= playMax) {
                playMax = count;
                min = Math.min(min, selected.size());
            }
            return;
        }

        selected.add(cur);
        recur(cur + 1, cnt + 1);
        selected.remove(selected.size() - 1);
        recur(cur + 1, cnt);
    }
}
