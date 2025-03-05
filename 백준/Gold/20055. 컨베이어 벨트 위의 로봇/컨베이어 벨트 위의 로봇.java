import java.util.Scanner;

public class Main {

    static int N;
    static int LIMIT;
    static int K;

    static int[] belt;
    static boolean[] robots;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        K = kb.nextInt();
        LIMIT = 2 * N;

        belt = new int[LIMIT];
        robots = new boolean[N];

        for (int i = 0; i < LIMIT; i++) {
            belt[i] = kb.nextInt();
        }

        int level = 0;
        while(true) {
            level++;
            // 1단계 컨테이너 벨트를 회전시킨다.
            int last = belt[LIMIT - 1];
            for (int i = LIMIT - 1; i > 0; i--) {
                belt[i] = belt[i - 1];
            }
            belt[0] = last;
            // 동시에 위의 로봇도 한칸씩 움직인다.
            for (int i = N - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }
            robots[N - 1] = false;
            robots[0] = false;

            // 2단계: 가장 먼저 올라간 로봇 부터 한칸씩 이동할 수 있으면 이동
            for (int i = N - 1; i > 0; i--) {
                // 현재 위치에 로봇이 없고, 이전 위치에 로봇이 있고, 현재 위치에 내구도가 1이상이면
                if (!robots[i] && robots[i - 1] && belt[i] > 0) {
                    boolean tmp = robots[i];
                    robots[i] = robots[i - 1];
                    robots[i - 1] = tmp;
                    belt[i] -= 1;
                }
                // 내리는 위치이고 로봇이 있다면 다시 로봇 내려준다.
                if (i == N - 1 && robots[N - 1]) {
                    robots[N - 1] = false;
                }
            }

            // 3단계: 올리는 위치의 내구도가 0이 아니면 로봇을 올린다.
            if (belt[0] > 0) {
                robots[0] = true;
                belt[0] -= 1;
            }

            int cnt = 0;
            for (int i = 0; i < LIMIT; i++) {
                if (belt[i] == 0) cnt++;
            }
            if (cnt >= K) {
                break;
            }
        }
        System.out.println(level);

    }
}
