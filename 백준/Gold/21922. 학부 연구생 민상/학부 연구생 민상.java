import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static class Wind{
        int y;
        int x;
        int d;

        public Wind(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    static int n;
    static int m;
    static int[][] board;
    static boolean[][][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];
        board = new int[n][m];
        visit = new boolean[n][m][4];
        for(int i=0;i<n;i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Queue<Wind> q = new LinkedList<>();
        int cnt=0;
        findAirConditioner(q);

        while (!q.isEmpty()){
            Wind wind = q.poll();
            int yy = wind.y + dy[wind.d];
            int xx = wind.x + dx[wind.d];
            if(0>yy || yy>=n || 0>xx || xx>=m) continue;
            if(visit[yy][xx][wind.d]) continue;
            visit[yy][xx][wind.d] = true;
            switch(board[yy][xx]) {
                case 1:
                    if (wind.d == 1 || wind.d == 3) continue;
                    break;
                case 2:
                    if (wind.d == 2 || wind.d == 0) continue;
                    break;
                case 3:
                    if (wind.d == 0) wind.d = 1;
                    else if (wind.d == 1) wind.d = 0;
                    else if (wind.d == 2) wind.d = 3;
                    else if (wind.d == 3) wind.d = 2;
                    break;
                case 4:
                    if (wind.d == 0) wind.d = 3;
                    else if (wind.d == 1) wind.d = 2;
                    else if (wind.d == 2) wind.d = 1;
                    else if (wind.d == 3) wind.d = 0;
                    break;
            }
                q.add(new Wind(yy,xx,wind.d));
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    for(int k=0;k<4;k++){
                        if(visit[i][j][k]){
                            cnt++;
                            break;
                        }
                    }
                }
            }
        System.out.println(cnt);
        }
    private static void findAirConditioner(Queue<Wind> q) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==9){
                    q.add(new Wind(i,j,0));
                    q.add(new Wind(i,j,1));
                    q.add(new Wind(i,j,2));
                    q.add(new Wind(i,j,3));
                    visit[i][j][0]=true;
                    visit[i][j][1]=true;
                    visit[i][j][2]=true;
                    visit[i][j][3]=true;
                }
            }
        }
    }
}
