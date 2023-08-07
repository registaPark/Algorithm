import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] paper ={0,5,5,5,5,5};
    static int[][] board = new int[10][10];
    static int c = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(0,0,0);
        if(c==Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(c);
    }

    private static void dfs(int y, int x, int cnt) {
        if(y>=9 && x>9){
            c = Math.min(c,cnt);
            return;
        }
        if(c<=cnt) return;
        if(x>9){
            dfs(y+1,0,cnt);
            return;
        }
        if(board[y][x]==1){
            for(int i=1;i<=5;i++){
                if(paper[i]>0 && canAttach(y,x,i)){
                    attach(y,x,i,0);
                    paper[i]--;
                    dfs(y, x+1, cnt+1);
                    attach(y,x,i,1);
                    paper[i]++;
                }
            }
        }else{
            dfs(y,x+1,cnt);
        }


    }

    private static void attach(int y, int x, int size,int a) {
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                board[i][j]=a;
            }
        }

    }

    private static boolean canAttach(int y, int x,int size) {
        for(int i=y;i<y+size;i++){
            for(int j=x;j<x+size;j++){
                if(i<0 || i>=10 || j<0 || j>=10){
                    return false;
                }
                if(board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }
}
