import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        int c = kb.nextInt();
        int students = kb.nextInt();

        int result = 0;
        outer:
        for (int i = 0; i <= 300; i++) {
            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    int first = a * i;
                    int second = b * j;
                    int third = c * k;

                    if (first + second + third == students) {
                        result = 1;
                        break outer;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
