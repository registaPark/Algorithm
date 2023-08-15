import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0];
        m = arr[1];
        board = new int[n][m];
        for(int i=0;i<n;i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int cheezeCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==1) cheezeCount++;
            }
        }
        int time=0;
        while (true){
            int[][] holeBoard = findHole();
            time++;
            int[][] meltedCheezeBoard = meltingCheeze(holeBoard);
            int leftCheeze = cleanBoard(meltedCheezeBoard);
            if(leftCheeze!=0) cheezeCount=leftCheeze;
            else{
                System.out.println(time);
                System.out.println(cheezeCount);
                break;
            }


        }

    }

    private static int cleanBoard(int[][] cheezeBoard) {
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(cheezeBoard[i][j]==2){
                    cheezeBoard[i][j]=0;
                } else if (cheezeBoard[i][j]==1) {
                    count++;
                }
            }
        }
        board = cheezeBoard;
        return count;
    }

    private static int[][] meltingCheeze(int[][] holeBoard) {
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(holeBoard[i][j]==1){
                    for(int k=0;k<4;k++){
                        int yy = i+dy[k];
                        int xx = j+dx[k];
                        if(0<=yy && yy<n && 0<=xx && xx<m && holeBoard[yy][xx]==2){
                            holeBoard[i][j]=0;
                            break;
                        }
                    }
                }
            }
        }
        return holeBoard;
    }

    private static int[][] findHole() {
        int[][] cloneBoard = board.clone();
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while (!q.isEmpty()){
            int[] poll = q.poll();
            for(int i=0;i<4;i++){
                int yy = poll[0] + dy[i];
                int xx = poll[1] + dx[i];
                if(0<=yy && yy<n && 0<=xx && xx<m && cloneBoard[yy][xx]==0){
                    cloneBoard[yy][xx] = 2;
                    q.add(new int[]{yy,xx});
                }
            }
        }
        return cloneBoard;
    }
}
