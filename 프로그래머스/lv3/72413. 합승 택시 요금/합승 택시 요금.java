import java.util.Arrays;


class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], 123456789);
            map[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }

        floydWarshall(map);
        int answer = map[s][a]+map[a][b];
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, map[s][i]+map[i][a]+map[i][b]);
        }

        return answer;
    }

    public void floydWarshall(int[][] map){
        int len = map.length-1;

        for (int k = 1; k <= len; k++) {
            for (int a = 1; a < len; a++) {
                for (int b = a+1; b <= len; b++) {
                    map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
                    map[b][a] = map[a][b];
                }
            }
        }
    }
}