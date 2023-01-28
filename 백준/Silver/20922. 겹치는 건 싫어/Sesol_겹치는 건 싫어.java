import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] count = new int[100001];
        int idx = 0;
        int answer = 0;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if(count[arr[i]]<k){
                count[arr[i]]++;
                answer = Math.max(answer, i-idx+1);
            }else{
                while(arr[idx]!=arr[i]){
                    count[arr[idx]]--;
                    idx++;
                }
                idx++;
            }
        }

        System.out.println(answer);

    }
}
