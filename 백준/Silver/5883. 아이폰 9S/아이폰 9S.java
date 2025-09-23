import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        N = kb.nextInt();
        arr = new int[N];
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int number = kb.nextInt();
            arr[i] = number;
            if (!map.containsKey(number)) {
                map.put(number, new ArrayList<Integer>());
            }
            map.get(number).add(i);
        }

        int answer = 1;
        for (int number : map.keySet()) {
            int max = 1;
            int sum = 1;
            int before = arr[0];
            for (int i = 1; i < N; i++) {
                if (number == arr[i]) continue; // 해당하는 숫자는 이미 빼진거라 생략
                if (before == arr[i]) {
                   sum++;
                }
                else {
                    sum = 1;
                    before = arr[i];
                }
                max = Math.max(max, sum);
            }
            answer = Math.max(answer, max);
        }
        System.out.println(answer);
    }
}
