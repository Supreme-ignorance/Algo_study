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

        recur(0, "", 0, 0);
    }

    // 현재 것 선택, 선택 안함
    static void recur(int cur, String seq, int jaum, int moum) {
        if (cur == C) {
            if (seq.length() == L && jaum >= 2 && moum >= 1) {
                System.out.println(seq);
            }
            return;
        }

        int nextJaumCnt = jaum;
        int nextMoumCnt = moum;
        if (isMoum(arr[cur])) {
            nextMoumCnt++;
        }
        else {
            nextJaumCnt++;
        }

        // 현재 것 선택 했을 때
        recur(cur + 1, seq + arr[cur], nextJaumCnt, nextMoumCnt);
        // 현재 것 선택 안했을 때
        recur(cur + 1, seq, jaum, moum);
    }

    static boolean isMoum(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
