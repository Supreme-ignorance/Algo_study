import java.util.Scanner;

public class Main {

    static long A;
    static long B;
    static long cnt;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        A = kb.nextInt();
        B = kb.nextInt();

        recur("4");
        recur("7");
        System.out.println(cnt);
    }

    static void recur(String cur) {
        if (A <= Long.parseLong(cur) && Long.parseLong(cur) <= B) {
//            System.out.println(cur);
            cnt++;
        }


        if (Long.parseLong(cur + "4") <= B) {
            recur(cur + "4");
        }
        if (Long.parseLong(cur + "7") <= B) {
            recur(cur + "7");
        }
    }

}
