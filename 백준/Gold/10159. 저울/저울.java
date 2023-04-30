import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                arr[i][j]=Integer.MAX_VALUE;
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[s[0]][s[1]] = 0;
            arr[s[1]][s[0]] = 1;
        }
        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(i==j) continue;
                    if(arr[i][k]+arr[k][j]==0) arr[i][j]=0;
                    if(arr[i][k]+arr[k][j]==2) arr[i][j]=1;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            int cnt=-1;
            for(int j=1;j<n+1;j++){
                if(arr[i][j]==Integer.MAX_VALUE) cnt++;
            }
            System.out.println(cnt);
        }
    }
}