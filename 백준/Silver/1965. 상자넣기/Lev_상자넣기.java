import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] boxes = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int boxSize = Integer.parseInt(tokenizer.nextToken());
            boxes[i] = boxSize;
        }//입력 완료

        int[] boxCounts = new int[N]; //몇개를 최대 담을 수 있는지 기록하는 배열
        int defaultValue = 1; //기본 값
        boxCounts[0] = defaultValue; //0번째는 1개가 기본값이다.

        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (boxes[j]  < boxes[i]) { //j번 box size가 i의 박스보다 작다면
                    max = Math.max(max, boxCounts[j]); //최대값 초기화
                }
            }
            boxCounts[i] = max + 1; //해당하는 상자까지 포함해야하기 때문에 + 1을 해서 boxCount를 초기화해준다.
        }
        
        int result = 1;
        for (int i = 1; i < N; i++) {
            result = Math.max(result, boxCounts[i]);
        }

        System.out.println(result);
    }
}