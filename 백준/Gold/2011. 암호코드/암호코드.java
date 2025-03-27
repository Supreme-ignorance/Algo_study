import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static long MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        String target = "0" + line;
        int size = target.length();
        long[] dp = new long[size];
        dp[0] = 1;

        for (int i = 1; i < size; i++) {
            String substring = target.substring(i - 1, i + 1);
            int number = Integer.parseInt(substring);
            if (number == 10 || number == 20) {
                dp[i] = dp[i - 2] % MOD;
            }
            else if (10 < number && number <= 26) { //11부터 26 사이라면
                dp[i] = (dp[i - 1] % MOD) + (dp[i - 2] % MOD);
            }
            else if (substring.charAt(1) > '0'){
                dp[i] = dp[i - 1] % MOD;
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[size - 1] % MOD);

    }
}