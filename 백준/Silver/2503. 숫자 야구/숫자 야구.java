import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static final int MAX_N = 100;

    static int[] numbers = new int[MAX_N];
    static int[] strikes = new int[MAX_N];
    static int[] balls = new int[MAX_N];

    static int N;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();

        for (int i = 0; i < N; i++) {
            int number = kb.nextInt();
            int strike = kb.nextInt();
            int ball = kb.nextInt();
            numbers[i] = number;
            strikes[i] = strike;
            balls[i] = ball;
        }

        int cnt = 0;


        for (int i = 111; i <= 999; i++) {
            boolean flag = true;
            for (int j = 0; j < N; j++) {
                if (!isAvailable(i, j)) {
                    flag = false;
                }
            }
            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isAvailable(int origin, int curIdx) {
        String o = String.valueOf(origin);
        String n = String.valueOf(numbers[curIdx]);

        if (o.contains("0")) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (int i = 0; i < o.length(); i++) {
            set.add(o.charAt(i));
        }
        if (set.size() != 3) return false;

        int strikeCnt = 0;
        int ballCnt = 0;

        outer:
        for (int i = 0; i < 3; i++) {
            char curOrigin = o.charAt(i);
            for (int j = 0; j < 3; j++) {
                char curN = n.charAt(j);
                if (curOrigin == curN) {
                    if (i == j) {
                        strikeCnt++;
                        continue outer;
                    } else {
                        ballCnt++;
                        continue outer;
                    }
                }
            }
        }

        if (strikeCnt == strikes[curIdx] && ballCnt == balls[curIdx]) {
            return true;
        }
        return false;

    }
}
