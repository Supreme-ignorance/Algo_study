import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 1; testCase <= T; testCase++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            long[] arr = new long[n];
            long max = 0;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                arr[n - 1 - i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    sum += max - arr[i];
                }
            }

            System.out.println(sum);

        }
    }
}