import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Queue<Location> q = new ArrayDeque<>();
        int answer = 0;

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    q.offer(new Location(i, j, 1));
                }
            }
        }

        while(!q.isEmpty()){
            Location cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];

                if(newX>=0 && newX<n && newY>=0 && newY<m && (map[newX][newY]==0 || map[newX][newY]>cur.dist+1)){
                    map[newX][newY] = cur.dist + 1;
                    q.offer(new Location(newX, newY, map[newX][newY]));
                    answer = Math.max(answer, map[newX][newY]);
                }
            }
        }

        System.out.println(answer-1);
    }

    static class Location{
        int x;
        int y;
        int dist;

        public Location(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}