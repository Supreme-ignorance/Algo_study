import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        for (int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(token.nextToken());
        }

        int left = 0;
        int right = 0;
        long sum = 0;

        Set<Integer> set = new HashSet<>();
        while (left < N || right < N) {
            // 먼저 right가 다 도착하면
            if (right == N) {
                sum += set.size();
                set.remove(arr[left]);
                left++;
                continue;
            }

            if (!set.contains(arr[right])) { //해당 값을 가지고 있지 않다면
                set.add(arr[right]);
                right++;
            }
            else {
                sum += set.size();
                set.remove(arr[left]);
                left++;
            }
        }
        System.out.println(sum);
    }
}