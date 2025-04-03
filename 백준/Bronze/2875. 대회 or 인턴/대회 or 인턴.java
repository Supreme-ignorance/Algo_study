import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int w = kb.nextInt();
        int m = kb.nextInt();
        int k = kb.nextInt();

        int max = Integer.MIN_VALUE;
        // 
        for (int i = 0; i <= k; i++) {
            int canW = w - i;
            int canM = m - (k - i);

            int teamW = canW / 2;
            int teamM = canM;
            int team = Math.min(teamM, teamW);
//            System.out.println("team available W : " + teamW);
//            System.out.println("team available M : " + teamM);
//            System.out.println("team min : " + team);
//            System.out.println();

            max = Math.max(max, team);
        }
        System.out.println(max);
    }
}
