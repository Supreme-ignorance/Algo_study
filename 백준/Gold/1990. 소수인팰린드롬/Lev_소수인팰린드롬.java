import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(tokenizer.nextToken());
        int b = Integer.parseInt(tokenizer.nextToken());

        boolean[] primeNumberValidation = new boolean[b + 1]; //최대 수보다 하나 더 많게
//        Arrays.fill(primeNumberValidation, true);
        for (int i = 2; i <= b; i++) {
            if (primeNumberValidation[i] == false) {
                for (int j = i * 2; j <= b; j += i) {
                    primeNumberValidation[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = a; i <= b; i++) {
            if (primeNumberValidation[i] != true) {
                String intToString = String.valueOf(i);
                int left = 0;
                int right = intToString.length() - 1;
                while(left <= right) {
                    if (intToString.charAt(left) != intToString.charAt(right)) {
                        break;
                    }
                    left++;
                    right--;
                }
                if (left > right) {
                    sb.append(i + "\n");
                }
            }
        }
        sb.append("-1\n");

        System.out.println(sb);
    }
}
