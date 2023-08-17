import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] distBoard;
    static class Knight{
        int y;
        int x;

        public Knight(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dy = {-2,-2,-1,-1,1,1,2,2};
    static int[] dx = {-1,1,-2,2,-2,2,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<int[]> horseList = new ArrayList<>();
        distBoard = new int[n][n];
        Knight knight = new Knight(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            horseList.add(new int[]{Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1});
        }
        BFS(knight);
        for(int i=0;i<m;i++){
            int[] horse = horseList.get(i);
            System.out.print(distBoard[horse[0]][horse[1]]+" ");
        }

    }

    private static void BFS(Knight k) {
        LinkedList<Knight> q = new LinkedList<>();
        q.add(k);
        while (!q.isEmpty()){
            Knight knight = q.poll();
            for(int i=0;i<8;i++){
                int yy = knight.y+dy[i];
                int xx = knight.x+dx[i];
                if(0<=yy && 0<=xx && yy<n && xx<n){
                    if(distBoard[yy][xx]==0){
                        distBoard[yy][xx] = distBoard[knight.y][knight.x]+1;
                        q.add(new Knight(yy,xx));
                    }
                }
            }
        }
    }
}
