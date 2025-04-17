import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L;
    static int C;
    static char[] arr;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        L = kb.nextInt();
        C = kb.nextInt();
        arr = new char[C];
        for (int i = 0; i < C; i++) {
            arr[i] = kb.next().charAt(0);
        }
        Arrays.sort(arr);

        recur(0, 0,"", 0, 0);
    }

    // cur == 현재 자리 수
    static void recur(int cur, int start, String seq, int jaum, int moum) {
        if (cur == L) {
            if (jaum >= 2 && moum >= 1) {
                System.out.println(seq);
            }
            return;
        }

        for (int i = start; i < C; i++) {
            int nextJaumCnt = jaum;
            int nextMoumCnt = moum;
            if (isMoum(arr[i])) {
                nextMoumCnt++;
            }
            else {
                nextJaumCnt++;
            }
            recur(cur + 1, i + 1, seq + arr[i], nextJaumCnt, nextMoumCnt);
        }

    }

    static boolean isMoum(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
