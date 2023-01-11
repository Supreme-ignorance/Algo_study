import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int answer = 0;
        Location[][] map = new Location[n+1][n+1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = new Location(i, j);
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if(x1-x2==1){
                map[x1][y1].road.add(1);
                map[x2][y2].road.add(0);
            }else if(x1-x2==-1){
                map[x1][y1].road.add(0);
                map[x2][y2].road.add(1);
            }else if(y1-y2==1){
                map[x1][y1].road.add(3);
                map[x2][y2].road.add(2);
            }else{
                map[x1][y1].road.add(2);
                map[x2][y2].road.add(3);
            }
        }

        Cow[] cows = new Cow[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            cows[i] = new Cow(x, y);
        }

        for (int i = 0; i < k; i++) {
            move(map, cows[i].x, cows[i].y, i);
            for (int j = i+1; j < k; j++) {
                if(map[cows[j].x][cows[j].y].cowNo!=i){
                    answer++;
                }
            }
        }

        System.out.println(answer);

    }

    private static void move(Location[][] map, int x, int y, int num) {
        Queue<Location> q = new ArrayDeque<>();
        q.offer(map[x][y]);

        while(!q.isEmpty()){
            Location cur = q.poll();
            for (int i = 0; i < 4; i++) {
                if(!cur.road.contains(i)){
                    int nX = cur.x + dx[i];
                    int nY = cur.y + dy[i];
                    if(nX>0 && nX<map.length && nY>0 && nY<map.length && map[nX][nY].cowNo != num){
                        q.offer(map[nX][nY]);
                        map[nX][nY].cowNo = num;
                    }
                }
            }
        }
    }


    static class Location{
        int x;
        int y;
        ArrayList<Integer> road = new ArrayList<>();
        int cowNo = -1;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Cow{
        int x;
        int y;

        public Cow(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}