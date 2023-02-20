import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Integer[] sushi = new Integer[n];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(c, 1);

        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
            if (i < k) {
                map.put(sushi[i], map.getOrDefault(sushi[i], 0)+1);
            }
        }

        int left = 0;
        int right = k - 1;
        int answer = map.keySet().size();

        while (left < n) {
            if (answer == k+1) {
                break;
            }
            if(map.get(sushi[left])==1){
                map.remove(sushi[left]);
            }else{
                map.put(sushi[left], map.get(sushi[left])-1);
            }
            left++;

            if (right < n - 1) {
                right++;
                map.put(sushi[right], map.getOrDefault(sushi[right], 0)+1);
            } else {
                right = 0;
                map.put(sushi[right], map.getOrDefault(sushi[right], 0)+1);

            }

            answer = Math.max(answer, map.keySet().size());
        }

        System.out.println(answer);
    }

}
