import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Byte.parseByte(st.nextToken());
        int k = Byte.parseByte(st.nextToken());
        boolean[] visited = new boolean[n];

        int[][] adjMat = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] distMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distMap[i], 987654321);
            distMap[i][i] = 0;
        }

        floydWarshall(adjMat, distMap);
        visited[k] = true;
        dfs(k, visited, 1, 0, distMap);
        System.out.println(answer);

    }

    private static void dfs(int start, boolean[] visited, int cnt, int dist, int[][] distMap) {
        if(cnt == distMap.length){
            answer = Math.min(answer, dist);
            return;
        }

        if(dist > answer){
            return;
        }

        for (int i = 0; i < distMap.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(i, visited, cnt+1, dist+distMap[start][i], distMap);
                visited[i] = false;
            }
        }
    }

    private static void floydWarshall(int[][] adjMat, int[][] distMap) {
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat.length; j++) {
                for (int k = 0; k < adjMat.length; k++) {
                    distMap[j][k] = Math.min(distMap[j][k], adjMat[j][i] + adjMat[i][k]);
                }
            }
        }
    }




}