import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int number = numbers[i];
            set.add(number);
            map.putIfAbsent(number, new ArrayList<>());
            map.get(number).add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] left = new int[N];
        int[] right = new int[N];

        for (int i = 1; i < list.size(); i++) {
            Integer number = list.get(i);
            List<Integer> indexes = map.get(number);

            for (int index : indexes) {
                int leftMax = -1;
                int rightMax = -1;
                for (int j = i - 1; j >= 0; j--) {
                    int before = list.get(j); // 그 전의 작은 수들
                    List<Integer> beforeIndexes = map.get(before); // 작은 수의 인덱스 리스트
                    for (int beforeIndex : beforeIndexes) {
                        if (beforeIndex < index) { // 해당 인덱스가 작으면 left를 찾아보고
                            leftMax = Math.max(leftMax, left[beforeIndex]);
                        }
                        else { // 해당 인덱스가 더 크면 right를 찾아본다.
                            rightMax = Math.max(rightMax, right[beforeIndex]);
                        }
                    }
                }
                left[index] = leftMax == -1 ? 0 : leftMax + 1;
                right[index] = rightMax == -1 ? 0 : rightMax + 1;
            }
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, left[i] + right[i]);
        }
        System.out.println(result + 1);
    }
}