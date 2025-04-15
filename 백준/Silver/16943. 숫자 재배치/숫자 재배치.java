import java.util.Scanner;

public class Main {

    static String A, B;
    static String[] arr;
    static int[] selected;
    static boolean[] visited;
    static int LIMIT;

    static long max = -1L;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        A = kb.next();
        B = kb.next();
        LIMIT = A.length();

        arr = new String[LIMIT];
        visited = new boolean[LIMIT];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = A.charAt(i) + "";
        }

        recur(0, "");
        System.out.println(max);
    }

    static void recur(int cur, String line) {
        // 기저조건
        if (cur == LIMIT) {
            if (line.charAt(0) != '0' && Long.parseLong(line) < Long.parseLong(B)) {
                max = Math.max(max, Long.parseLong(line));
            }
            return;
        }

        for (int i = 0; i < LIMIT; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            recur(cur + 1, line + arr[i]);
            visited[i] = false;
        }
    }
}
