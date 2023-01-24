import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        int accSum = 0;
        int pointer = 0;
        Map<Integer, Integer> colorSum = new HashMap<>();
        Ball[] balls = new Ball[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            balls[i] = new Ball(c, s, i);
        }

        Arrays.sort(balls);
        for (Ball ball : balls) {
            while (balls[pointer].size < ball.size) {
                accSum += balls[pointer].size;
                colorSum.put(balls[pointer].color, colorSum.getOrDefault(balls[pointer].color, 0)+balls[pointer].size);
                pointer++;
            }
            answer[ball.idx] = accSum - colorSum.getOrDefault(ball.color, 0);
        }

        for (int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();


    }

    static class Ball implements Comparable<Ball> {

        int color;
        int size;
        int idx;

        public Ball(int color, int size, int idx) {
            this.color = color;
            this.size = size;
            this.idx = idx;
        }

        @Override
        public int compareTo(Ball o) {
            if (this.size == o.size) {
                return this.color - o.color;
            }
            return this.size - o.size;
        }
    }
}