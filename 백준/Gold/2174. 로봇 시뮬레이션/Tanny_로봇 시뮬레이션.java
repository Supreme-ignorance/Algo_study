import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int R, C, N, M, id;
    // 북 서 남 동
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static HashMap<String, Integer> directionMap;
    static String[] result;
    static String[] directions = {"N", "W", "S", "E"};
    static int[][] map;
    static HashMap<Integer, Robot> robots;

    public static class Robot {
        int cr;
        int cc;
        String ch;

        public Robot() {
        }

        public Robot(int cr, int cc, String ch) {
            this.cr = cr;
            this.cc = cc;
            this.ch = ch;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt(); // 5
        R = sc.nextInt(); // 4
        N = sc.nextInt();
        M = sc.nextInt();

        directionMap = new HashMap<>();
        for (int d = 0; d < directions.length; d++) {
            directionMap.put(directions[d], d);
        }

        // R = 4, C = 5
        map = new int[R][C];
        robots = new HashMap<>();
        id = 0;
        result = new String[1];

        for (int n = 0; n < N; n++) {
            // R = 4 C = 5
            // 1, 1 (c, r) => 3, 0 (r, c)
            // 5, 4 (c, r) => 0, 4 (r, c)
            int cc = sc.nextInt() - 1;
            int cr = R - sc.nextInt();
            String ch = sc.next();
            Robot robot = new Robot(cr, cc, ch);

            robots.put(++id, robot);
            map[cr][cc] = id;
        }

        for (int m = 0; m < M; m++) {
            int cid = sc.nextInt();

            Robot crobot = robots.get(cid);

            String cmd = sc.next();
            int repeat = sc.nextInt();

            simulation(crobot, cmd, repeat);
            if (result.length == 2) {
                break;
            }
        }

        if (result.length == 1) {
            System.out.println("OK");
        }
    }

    private static void simulation(Robot crobot, String cmd, int repeat) {
        while(repeat-- != 0) {
            if (cmd.equals("L")) {
                turnLeft(crobot);
            }
            if (cmd.equals("R")) {
                turnRight(crobot);
            }
            if (cmd.equals("F")) {
                goStraight(crobot);
                if (result.length == 2) {
                    System.out.println(result[0] + " crashes into " + result[1]);
                    break;
                }
            }
        }
    }

    private static void goStraight(Robot crobot) {
        int head = directionMap.get(crobot.ch);

        int rid = map[crobot.cr][crobot.cc];

        int nr = crobot.cr + dr[head];
        int nc = crobot.cc + dc[head];

        // 벽에 안 부딪힘
        if (nr >= 0 && nc >= 0 && nr < R && nc < C ) {
            // 다음 체크했는데 빈 공간
            if (map[nr][nc] == 0) {
                map[crobot.cr][crobot.cc] = 0;
                map[nr][nc] = rid;

                crobot.cr = nr;
                crobot.cc = nc;
                return;
            }
            // 다음 체크했는데 로봇에 부딪힘
            // 로봇에 부딪힘
            if (map[nr][nc] != 0) {
                result = new String[2];
                result[0] = "Robot " + Integer.toString(rid);
                result[1] = "robot " + Integer.toString(map[nr][nc]);
                return;
            }

        }

        // 벽에 부딪힘
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
            result = new String[2];
            result[0] = "Robot " + Integer.toString(rid);
            result[1] = "the wall";
            return;
        }
    }

    private static void turnRight(Robot crobot) {
        // 현재 머리방향을 확인
        int head = directionMap.get(crobot.ch);

        // trunRight하고
        if (head != 0) {
            crobot.ch = directions[head - 1];
            return;
        }
        if (head == 0) {
            crobot.ch = directions[3];
        }
        return;
    }

    private static void turnLeft(Robot crobot) {
        // 현재 머리방향을 확인
        int head = directionMap.get(crobot.ch);

        // trunleft하고
        if (head != 3) {
            crobot.ch = directions[head + 1];
            return;
        }
        if (head == 3) {
            crobot.ch = directions[0];
        }
        return;
    }
}