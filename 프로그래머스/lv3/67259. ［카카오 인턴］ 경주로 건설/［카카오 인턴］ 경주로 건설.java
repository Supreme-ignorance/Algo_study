import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] board) {        
        
        return Math.min(bfs(new Node(0, 0, 0, 0), createPriceMap(board.length), board), bfs(new Node(0, 0, 1, 0), createPriceMap(board.length), board));
    }
    
    public int[][] createPriceMap(int n) {
        int[][] priceMap = new int[n][n];
        priceMap[0][0] = 0;
        for(int i=0; i<priceMap.length; i++){
                Arrays.fill(priceMap[i], Integer.MAX_VALUE);    
        } 
        return priceMap;
    }
    
    public int bfs(Node node, int[][] priceMap, int[][] board){
        Queue<Node> pq = new ArrayDeque<>();
        pq.offer(node);
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            for(int i=0; i<4; i++){
                int nX = cur.x+dx[i];
                int nY = cur.y+dy[i];
                if(nX>=0 && nX<board.length && nY>=0 && nY<board.length && board[nX][nY]==0){
                    int nPrice = cur.price;
                    if(i != cur.dir){
                        nPrice+=600;    
                    }else{
                        nPrice+=100;    
                    }
                    if(priceMap[nX][nY] >= nPrice){
                        priceMap[nX][nY] = nPrice;
                        pq.offer(new Node(nX, nY, i, nPrice));
                    }
                }
            }
        }
        
        return priceMap[board.length-1][board.length-1];
    }
    
    static class Node{
        int x;
        int y;
        int dir;
        int price;
        
        public Node(int x, int y, int dir, int price){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.price = price;
        }
        
    }
}