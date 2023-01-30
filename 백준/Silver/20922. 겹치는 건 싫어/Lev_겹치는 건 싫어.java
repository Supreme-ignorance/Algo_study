import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken()); //개수
        int K = Integer.parseInt(tokenizer.nextToken()); //겹치는 최대 수

        int[] numbers = new int[N];
        tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        } //세팅 완료

        int[] map = new int[100_001];
        int max = 0;

        //투포인터
        int left = 0; //왼쪽
        int right = 0;
        for (; right < N; right++) { //오른쪽
            int index = numbers[right];
            map[index]++;
            if (map[index] > K) {
                max = Math.max(max, ((right - left)));
                while (numbers[left] != index) {
                    map[numbers[left]]--;
                    left++; //레프트 증가하기
                }
                //numbers[left] == index면 마지막으로 한 번 더 해준다.
                map[numbers[left]]--;
                left++;
            }
        }
        max = Math.max(max, right - left);

        System.out.println(max);
    }

    private static boolean checkOversize(Map<Integer, Integer> map, int maxSize) {
        return map.containsValue(maxSize + 1);
    }
}