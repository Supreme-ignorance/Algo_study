import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, K;
    static List<String> results = new ArrayList<>();


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();

        recur(0, "");
        if (results.size() < K) {
            System.out.println(-1);
        }
        else {
            System.out.println(results.get(K - 1));
        }
    }

    static void recur(int sum, String line) {
        if (sum >= N) { // sum이 더 크면 더 이상 볼 필요가 없음
            if (sum == N) { // 그 중에서 딱 N으로 떨어진다면
                String result = "";
                for (int i = 0; i < line.length() - 1; i++) {
                    result += (line.charAt(i) + "+");
                }
                result += (line.charAt(line.length() - 1));
//                System.out.println(result);
                results.add(result);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            recur(sum + i, line + i);
        }
    }
}
