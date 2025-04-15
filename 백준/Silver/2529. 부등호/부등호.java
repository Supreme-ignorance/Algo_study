import java.util.Scanner;

public class Main {

    static int N;
    static char[] sequence;
    static int[] selected;
    static boolean[] visited = new boolean[10];
    static long max = Long.MIN_VALUE;
    static String maxString = "";
    static long min = Long.MAX_VALUE;
    static String minString = "";

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        sequence = new char[N];
        selected = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sequence[i] = kb.next().charAt(0);
        }

        recur(0);
        System.out.println(maxString);
        System.out.println(minString);
    }

    static void recur(int cur) {
        // 기저조건
        if (cur == N + 1) {
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (sequence[i] == '>') {
                    if (selected[i] <= selected[i + 1]) {
                        flag = false;
                        break;
                    }
                }
                else {
                    if (selected[i] >= selected[i + 1]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                String s = convert();
                long number = Long.parseLong(s);
                if (number > max) {
                    max = number;
                    maxString = s;
                }
                if (number < min) {
                    min = number;
                    minString = s;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) continue;
            selected[cur] = i;
            visited[i] = true;
            recur(cur + 1);
            visited[i] = false;
        }
    }

    static String convert() {
        String s = "";
        for (int i = 0; i < N + 1; i++) {
            s += selected[i];
        }
        return s;
    }
}
