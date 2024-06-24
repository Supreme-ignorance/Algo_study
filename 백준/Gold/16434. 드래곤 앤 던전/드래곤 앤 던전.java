import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static long myAttack;
    static long[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(token.nextToken());
        myAttack = Long.parseLong(token.nextToken());
        long startHp = 1L;
        long endHp = ((long) N) * 1_000_000L * 1_000_000L;


        map = new long[N][3];
        for (int i = 0; i < N; i++) {
            token = new StringTokenizer(br.readLine(), " ");
            long type = Long.parseLong(token.nextToken());
            long targetAttack = Long.parseLong(token.nextToken());
            long targetHp = Long.parseLong(token.nextToken());
            map[i] = new long[]{type, targetAttack, targetHp};
        }

        while (startHp <= endHp) {
            long mid = (startHp + endHp) / 2L;

            if (simulation(mid)) {
                endHp = mid - 1;
            }
            else {
                startHp = mid + 1;
            }
        }
        System.out.println(startHp);

    }

    public static boolean simulation(long maxHp) {
        long currentHp = maxHp;
        long currentAttack = myAttack;

        for (int i = 0; i < N; i++) {
            long[] currentMap = map[i];
            if (currentMap[0] == 2) {
                currentAttack += currentMap[1];
                if (currentHp + currentMap[2] >= maxHp) {
                    currentHp = maxHp;
                }
                else {
                    currentHp += currentMap[2];
                }
            }
            else { // 1 몬스터이면
                long monsterAttack = currentMap[1];
                long monsterHp = currentMap[2];

                long myDamage = ((monsterHp / currentAttack)) * monsterAttack;
                myDamage += (monsterHp % currentAttack == 0 ? -monsterAttack : 0);

                if (myDamage >= currentHp) { // HP가 0 이하라면
                    return false;
                }
                else { // HP가 1 이상이라면
                    currentHp -= myDamage;
                }
            }
        }
        return true;
    }
}