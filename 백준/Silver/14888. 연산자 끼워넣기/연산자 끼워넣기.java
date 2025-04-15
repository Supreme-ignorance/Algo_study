import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] numbers;
    static int[] operators = new int[4];
    static String[] arr;
    static String[] selected;
    static boolean[] visited;
    static int limit;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = kb.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            operators[i] = kb.nextInt();
        }

        String line = "";
        for (int i = 0; i < operators.length; i++) {
            int cnt = operators[i];
            for (int j = 0; j < cnt; j++) {
                if (i == 0) {
                    line += "+";
                }
                if (i == 1) {
                    line += "-";
                }
                if (i == 2) {
                    line += "*";
                }
                if (i == 3) {
                    line += "/";
                }
            }
        }

        limit = line.length();
        arr = new String[limit];
        selected = new String[limit];
        visited = new boolean[limit];
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i) + "";
        }
        
        recur(0, numbers[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void recur(int cur, int result) {
        // 기저조건
        if (cur == limit) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < limit; i++) {
            if (visited[i]) continue;
//            selected[cur] = arr[i];

            int next = result;
            if (arr[i].equals("+")) {
                next += numbers[cur + 1];
            }
            if (arr[i].equals("-")) {
                next -= numbers[cur + 1];
            }
            if (arr[i].equals("*")) {
                next *= numbers[cur + 1];
            }
            if (arr[i].equals("/")) {
                if (result < 0) {
                    next = -(Math.abs(result) / numbers[cur + 1]);
                }
                else {
                    next /= numbers[cur + 1];
                }
            }
            visited[i] = true;
            recur(cur + 1, next);
            visited[i] = false;
        }
    }
}
