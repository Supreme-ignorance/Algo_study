import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static int[][] adjMatrix;
    private static int[][] map;

    private static int N;
    private static int Q;

    private static class Video {
        int no;
        int usado;

        public Video(int no, int usado) {
            this.no = no;
            this.usado = usado;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        N = Integer.parseInt(tokenizer.nextToken()); //N개의 동영상
        Q = Integer.parseInt(tokenizer.nextToken()); //존의 질문 개수

//        Scanner kb = new Scanner(System.in);
//
//        N = kb.nextInt(); // N개의 동영상
//        Q = kb.nextInt(); // 존의 질문 개수

        List<Video>[] adjList = new List[N + 1]; //인접리스트, +1은 0번 배열은 버릴려고
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int usado = Integer.parseInt(tokenizer.nextToken());

            adjList[from].add(new Video(to, usado));
            adjList[to].add(new Video(from, usado));
        } // N - 1개의 USADO 정보

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(tokenizer.nextToken());
            int startNumber = Integer.parseInt(tokenizer.nextToken());
            Video startVideo = new Video(startNumber, Integer.MAX_VALUE);
            int[] counts = new int[N + 1];

            Queue<Video> queue = new ArrayDeque<>();
            queue.offer(startVideo);
            counts[startNumber] = Integer.MAX_VALUE;

            while (!queue.isEmpty()) {
                Video foundVideo = queue.poll();

                for (int j = 0; j < adjList[foundVideo.no].size(); j++) {
                    Video video = adjList[foundVideo.no].get(j);
                    if (counts[video.no] == 0) { //아직 안들렸다면
                        counts[video.no] = Math.min(video.usado, counts[foundVideo.no]); //찾은 비디오(foundVide)의 최소 우사도 기록이나 video의 우사도 기록을 비교
                        queue.offer(video);
                    }
                }
            }
            sb.append(getCount(counts, K) + "\n");
        }
        System.out.println(sb);
    }

    private static int getCount(int[] counts, int K) {
        int count = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] >= K && counts[i] != Integer.MAX_VALUE) {
                count++;
            }
        }
        return count;
    }
}