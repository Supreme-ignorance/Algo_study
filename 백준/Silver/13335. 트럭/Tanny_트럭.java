import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, w, L;
    static int[] trucks, units;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());


        trucks = new int[n + 1];
        units = new int[n + 1];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < n ; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        // 머리이상 꼬리미만 까지 다리에 들어가있다.
        int head = 0;
        int tail = 1;
        int time = 0;

        // 1초가 지날때마다
        while (head < n) {
            time++;
            
            int totalWeight = 0;
            boolean isTailMoved = false;

            // 1. 머리이상 꼬리미만 움직여주기
            // 무게도 더해주기
            for (int index = head; index < tail; index++) {
                units[index]++;
                totalWeight += trucks[index];
            }

            // 2. 머리가 탈출하면 탈출한 머리 무게 빼주고
            // 머리 좌표 이동하고
            // 새로운 머리 무게 더해주고 움직임 +1
            if (units[head] > w) {
                totalWeight -= trucks[head];
                head++;
                if (units[head] == 0) {
                    units[head]++;
                    totalWeight += trucks[head];
                }

                // 만약 머리랑 tail 위치 같으면 tail+1
                if (head == tail) {
                    tail++;
                    isTailMoved = true;
                }
            }

            // 3. 꼬리 늘릴지 말지 결정해주기.
            if (tail < n && !isTailMoved && totalWeight + trucks[tail] <= L) {
                units[tail]++;
                tail++;
            }
        }
        System.out.println(time);
    }
}