import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int alp, int cop, int[][] problems) {
        
        // List<List<Integer>> p = new ArrayList<>();
        // p.add(Arrays.asList(0, 0, 1, 0, 1));
        // p.add(Arrays.asList(0, 0, 0, 1, 1));
        int[][] p = new int[problems.length + 2][5];
        p[0] = new int[] {0, 0, 1, 0, 1};
        p[1] = new int[] {0, 0, 0, 1, 1};
        
        int needAlp = 0;
        int needCop = 0;
        for (int i = 0; i < problems.length; i++) {
            if (needAlp < problems[i][0]) {
                needAlp = problems[i][0];
            }
            if (needCop < problems[i][1]) {
                needCop = problems[i][1];
            }
            p[i + 2] = problems[i];
        }
        // for (int[] temp : p) {
        //     System.out.println(Arrays.toString(temp));
        // }
        
        Queue<Node> q = new PriorityQueue<>((a, b) -> a.time - b.time);
        q.add(new Node(alp, cop, 0));
        //알고력, 코딩력을 기록하는 메모이제이션
        int[][] dist = new int[150 + 1][150 + 1];
        boolean[][] visited = new boolean[150 + 1][150 + 1];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[alp][cop] = 0;
        
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            // System.out.println(cur);
            
            if (cur.alp >= needAlp && cur.cop >= needCop) {
                return cur.time;
            }
            if (!visited[cur.alp][cur.cop]) {//방문하지 않았다면
                visited[cur.alp][cur.cop] = true; //방문처리를 해준다.
                for (int i = 0; i < p.length; i++) {
                    int reqAlp = p[i][0];
                    int reqCop = p[i][1];
                    int getAlp = p[i][2];
                    int getCop = p[i][3];
                    int getTime = p[i][4];
                    
                    if (cur.alp >= reqAlp && cur.cop >= reqCop) {
                        int nextAlp = cur.alp + getAlp >= 150 ? 150 : cur.alp + getAlp;
                        int nextCop = cur.cop + getCop >= 150 ? 150 : cur.cop + getCop;
                        
                        if (dist[nextAlp][nextCop] > cur.time + getTime) {
                            dist[nextAlp][nextCop] = cur.time + getTime;
                            q.add(new Node(nextAlp, nextCop, dist[nextAlp][nextCop]));
                        }
                    }
                }
            }
        }
        
        int answer = 0;
        return answer;
    }
    
    static class Node {
        int alp;
        int cop;
        int time;
        
        Node (int a, int c, int t) {
            alp = a;
            cop = c;
            time = t;
        }
        
        public String toString() {
            return "alp : " + alp + " / " + "cop : " + cop + " / " + "time : " + time;
        }
    }
}