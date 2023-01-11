import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        int[][] distMap = new int[n+1][n+1];
        boolean[] checkedNum = new boolean[n+1];

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, r));
            graph.get(end).add(new Node(start, r));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(!checkedNum[v]){
                fillDistMap(graph, v, distMap);
                checkedNum[v] = true;
            }
            System.out.println(countVideo(k, v, distMap));
        }


    }

    private static int countVideo(int k, int v, int[][] distMap) {
        int cnt = 0;
        for (int i : distMap[v]) {
            if(i>=k){
                cnt++;
            }
        }
        return cnt;
    }

    private static void fillDistMap(ArrayList<ArrayList<Node>> graph, int videoNum, int[][] distMap) {
        boolean[] visited = new boolean[graph.size()];
        visited[videoNum]= true;

        Queue<Node> q = new ArrayDeque<>();
        for (Node node : graph.get(videoNum)) {
            q.offer(node);
            distMap[videoNum][node.num] = node.dist;
        }

        while (!q.isEmpty()){
            Node cur = q.poll();
            visited[cur.num] = true;

            for(Node node : graph.get(cur.num)){
                if(!visited[node.num]){
                    q.offer(node);
                    distMap[videoNum][node.num] = Math.min(distMap[videoNum][cur.num], node.dist);

                }
            }
        }
    }


    static class Node{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }
    }

}