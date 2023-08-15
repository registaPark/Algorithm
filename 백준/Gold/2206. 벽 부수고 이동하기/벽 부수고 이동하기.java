import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static class Man{
        int y;
        int x;
        int dist;
        boolean breakWall;

        public Man(int y, int x, int dist, boolean breakWall) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.breakWall = breakWall;
        }
    }
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        LinkedList<Man> q = new LinkedList<>();
        q.add(new Man(0,0,1,false));
        boolean[][][] visit = new boolean[n][m][2];
        while (!q.isEmpty()){
            Man man = q.poll();
            if(man.y == n-1 && man.x == m-1){
                System.out.println(man.dist);
                return;
            }
            for(int i=0;i<4;i++){
                int yy = man.y + dy[i];
                int xx = man.x + dx[i];
                if(0>yy || yy>=n || 0>xx || xx>=m) continue;
                if(board[yy][xx]==0){
                    if(!man.breakWall && !visit[yy][xx][0]){
                        q.add(new Man(yy,xx,man.dist+1,false));
                        visit[yy][xx][0] = true;
                    }else if(man.breakWall && !visit[yy][xx][1]){
                        q.add(new Man(yy,xx,man.dist+1,true));
                        visit[yy][xx][1] = true;
                    }
                }
                else{
                    if(!man.breakWall){
                        q.add(new Man(yy,xx,man.dist+1,true));
                        visit[yy][xx][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
