import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int T, N;
    static long energy;
    static final long mod = 1000000007;
    static PriorityQueue<Long> slimes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            energy = 1;

            slimes = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                slimes.offer(Long.parseLong(st.nextToken()));
            }

            while (slimes.size() > 1) {
                Long slime1 = slimes.poll();
                Long slime2 = slimes.poll();
                Long newSlime = slime1 * slime2;
                energy *= newSlime % mod;
                energy %= mod;
                slimes.offer(newSlime);
            }

            sb.append(energy + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}