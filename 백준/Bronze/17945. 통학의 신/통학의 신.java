import java.util.Scanner;

public class Main {

    static int A;
    static int B;

    static int resultA;
    static int resultB;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        A = kb.nextInt();
        B = kb.nextInt();

        // MOD 할때 0인 숫자들만
        // 그리고 원래 숫자가 그대로 나오면 이미 여기서부터는 더 큰 숫자임

        for (int i = 1; i <= 1005; i++) {
            int result = B % i;

            if (result == 0 && i + (B / i) == (A * 2)) {
                resultA = Math.min(-i, -(B / i));
                resultB = Math.max(-i, -(B / i));
            }
        }

        if (resultA == resultB) {
            System.out.println(resultA);
        }
        else {
            System.out.print(resultA + " " + resultB);
        }

        // 그리고 나오는 숫자의 반대가 해당 숫자이다.
    }
}
