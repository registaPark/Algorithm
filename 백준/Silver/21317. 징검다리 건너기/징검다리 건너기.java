import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static boolean flag = false;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[30][2];
        int[][] jumps = new int[30][2];
        for(int i=1;i<n;i++){
            jumps[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=2;i<30;i++){
            dp[i][0] = 1000000;
            dp[i][1] = 1000000;
        }
        dp[2][0] = jumps[1][0];
        dp[3][0] = Math.min(jumps[1][0]+jumps[2][0],jumps[1][1]);
        int veryBigJump = Integer.parseInt(br.readLine());
        for(int i=4;i<=n;i++){
            dp[i][0] =Math.min(Math.min(dp[i][0],dp[i-1][0]+jumps[i-1][0]),dp[i-2][0]+jumps[i-2][1]);
            dp[i][1] = Math.min(dp[i][1],dp[i-3][0]+veryBigJump);
            dp[i][1] =Math.min(Math.min(dp[i][1],dp[i-1][1]+jumps[i-1][0]),dp[i-2][1]+jumps[i-2][1]);
        }
        System.out.println(Math.min(dp[n][0],dp[n][1]));
    }
}
