import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        int n = kb.nextInt();
        int w = kb.nextInt();

        String answer = "-1";

        for (int i = 1; i < n; i++) { // 양이 1마리인것부터 찾자
            int rest = w - (i * a); // 염소에게 남은 양
            if (rest % b == 0 && n == i + (rest / b)) {
                if (answer.equals("-1")) {
                    answer = i + " " + (n - i);
                }
                else {
                    answer = "-1";
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
