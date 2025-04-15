import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] day;
    static int[] money;
    static boolean[] visited;
    static List<Integer> selected = new ArrayList<>();

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        day = new int[N];
        money = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            day[i] = kb.nextInt();
            money[i] = kb.nextInt();
        }

        recur(0);
        System.out.println(max);
    }

    static void recur(int curDay) {
       if (curDay >= N) {
           int total = 0;
           for (int i = 0; i < N; i++) {
               if (visited[i]) {
                   total += money[i];
               }
           }
           max = Math.max(max, total);
           return;
       }

       if (curDay + day[curDay] - 1 < N) {
           visited[curDay] = true;
           recur(curDay + day[curDay]);
       }
       visited[curDay] = false;
       recur(curDay + 1);
    }
}
