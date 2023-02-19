import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] dp;
    static int[][] schedule;

    public static void main(String[] args) {

        /**
         *  1. 1일차부터 brute force 로 조사한다. 1일차에 상담하는 경우를 고르고, 이후 가능한 날짜를 차례로 구하는 방식
         *  2. 메모이제이션으로 해당 날짜의 금액을 업데이트 해준다.
         *  3. 다음 경우의 수를 따질때 특정 날짜에서 얻을 수 있는 수익이
         *   3-1. 이미 메모된 숫자보다 큰 경우만 메모하고(그 날짜 까지는 해당 방식을 선택하겠다는 의미)
         *   3-2. 작다면 메모하지 않는다.(그 날짜 까지는 해당 방식을 선택하지 않고 이전에 선택한 방식으로 가겠다는 의미)
         *  4. 7번째(index 6)날의 값을 구하면 그것이 최대 값이된다.
         *
         *  주의) 상담 기간이 1이면 해당일에 상담이 바로 마무리 되어 돈을 받는다. (7일차에 T가 1일경우 상담 가능)
         *  주의) 날짜는 앞에서 뒤로만 간다. 조합으로 풀자.
         */

        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        schedule = new int[N][2];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        /**
         * nowDay, visited(상담을 했는지), 현재 수익금
         */
        combination(0, 0);

        Arrays.sort(dp);
        System.out.println(Math.max(dp[N], dp[N - 1]));
    }

    private static void combination(int nowDay, int nowIncome) {
        // 현재 날짜가 근무 마지막날이 된다면
        if (nowDay == N - 1) {
            // 마지막날 상담 스케쥴이 1일짜리 라면
            if (schedule[nowDay][0] == 1) {
                // dp의 마지막날 메모이제이션과 마지막날 income 을 더한것을 비교하여 큰것을 넣어주자
                dp[nowDay + 1] = Math.max(dp[nowDay + 1], nowIncome + schedule[nowDay][1]);
            }
            return;
        }

        // 현재 날짜부터 마지막 날짜까지 경우의 수를 찾는다.
        for (int i = nowDay; i < N; i++) {

            // 다음 상담 시작일(상담 종료날짜는 이전날이 된다)
            int nextConsultingDay = i + schedule[i][0];

            // 다음 상담 시작일이 근무마지막날 (N)의 다음날이라면
            // 지금 상담은 근무 마지막날에 끝난다는 뜻
            if (nextConsultingDay > N) {
                continue;
            }


            // 돈을 벌었으니 수익금에 반영하자
            nowIncome += schedule[i][1];

            // 만약 메모된 이전의 수익금보다 현재 수익금이 크다면
            // 지금 스케줄이 이득이니 바꿔서 메모하자
            if (dp[nextConsultingDay] < nowIncome){
                dp[nextConsultingDay] = nowIncome;
            }

            combination(nextConsultingDay, nowIncome);

            // 일을 안했다고 가정하고 넘어가자
            nowIncome -= schedule[i][1];

        }
    }
}