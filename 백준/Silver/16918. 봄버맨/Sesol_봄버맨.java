import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int r, c, n;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            Arrays.fill(map[i], -1);
            for (int j = 0; j < c; j++) {
                if(line.charAt(j)=='O'){
                    map[i][j] = 2;
                }
            }
        }

        while(n>1){
            bombPlant();
            if(n==1){
                break;
            }
            bomb();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==-1){
                    System.out.print(".");
                }else{
                    System.out.print("O");
                }
            }
            System.out.println();
        }

    }

    private static void bombPlant() {
        countDown();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == -1){
                    map[i][j] = 3;
                }
            }
        }
        n--;
    }

    private static void bomb() {
        countDown();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]==0){
                    map[i][j] = -1;
                    for (int k = 0; k < 4; k++) {
                        int nX = i+dx[k];
                        int nY = j+dy[k];
                        if(nX>=0 && nX<r && nY>=0 && nY<c && map[nX][nY]!=0){
                            map[nX][nY] = -1;
                        }
                    }
                }
            }
        }
        n--;
    }

    private static void countDown() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j]>0){
                    map[i][j]--;
                }
            }
        }
    }

}