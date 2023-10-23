import java.util.*;
class Solution {
    int[] dy = {-1,1,0,0};
    int[] dx = {0,0,1,-1};
    int[][][] visit;
    class Pos{
        int y;
        int x;
        int dir;
        public Pos(int y,int x,int dir){
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    public int solution(int[][] board) {
        Queue<Pos> q = new LinkedList<>();
        visit = new int[board.length][board.length][4];
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                for(int k=0;k<4;k++){
                    visit[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<4;i++){
            visit[0][0][i] = 0;
            q.add(new Pos(0,0,i));
        }
        int sum = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pos pos = q.poll();
            if(pos.y == board.length-1 && pos.x == board.length-1){
                sum = Math.min(sum,visit[pos.y][pos.x][pos.dir]);
                continue;
            }
            for(int i=0;i<4;i++){
                int yy = pos.y + dy[i];
                int xx = pos.x +dx[i];
                if(0<=yy && 0<=xx && yy<board.length && xx<board.length && board[yy][xx]!=1){
                    int cost = visit[pos.y][pos.x][pos.dir] + 100;
                    if(pos.dir!=i) cost+=500;
                    if(visit[yy][xx][i]==Integer.MAX_VALUE || visit[yy][xx][i]>=cost){
                        q.add(new Pos(yy,xx,i));
                        visit[yy][xx][i] = cost;
                    }
                }
            }
        }
        int answer = 0;
        return sum;
    }
}