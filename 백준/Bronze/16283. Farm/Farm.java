import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        int n = kb.nextInt();
        int w = kb.nextInt();

        //String answer = "-1";
        List<int[]> answer = new ArrayList<>();

        for (int i = 1; i < n; i++) { // 양이 1마리인것부터 찾자
            int rest = w - (i * a); // 염소에게 남은 양
            if (rest % b == 0 && n == i + (rest / b)) {
                if (answer.isEmpty()) {
                    answer.add(new int[]{i, n - i});
                }
                else {
                    answer.add(new int[]{i, n - i});
                    break;
                }
            }
        }

        if (answer.size() != 1) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer.get(0)[0] + " " + answer.get(0)[1]);
        }
    }
}
