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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = arr[0];
            int m = arr[1];
            int[][] board = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            for(int j=0;j<n;j++){
                String s = br.readLine();
                for(int k=0;k<s.length();k++){
                    if(s.charAt(k)=='#') board[j][k] = 1;
                    else board[j][k] = 0;
                }
            }
            Queue<int[]> q = new LinkedList<>();
            int cnt=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    if(board[j][k]==1 && !visit[j][k]){
                        visit[j][k] = true;
                        cnt++;
                        q.add(new int[]{j,k});
                        while (!q.isEmpty()){
                            int[] poll = q.poll();
                            for(int s=0;s<4;s++){
                                int yy = poll[0]+dy[s];
                                int xx = poll[1]+dx[s];
                                if(0<=yy && yy<n && 0<=xx && xx<m && board[yy][xx]==1 && !visit[yy][xx]){
                                    visit[yy][xx] = true;
                                    q.add(new int[]{yy,xx});
                                }
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
