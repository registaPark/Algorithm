import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int c = arr[0];
        int n = arr[1];
        int[] dp = new int[c+102];
        Arrays.fill(dp,100000);
        for(int i=0;i<n;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            dp[s[1]] = Math.min(dp[s[1]],s[0]);
        }
        for(int i=1;i<=c+101;i++){
            for(int j=i-1;j>=0;j--){
                dp[i] = Math.min(dp[i],dp[j]+dp[i-j]);
            }
        }
        int r = Integer.MAX_VALUE;
        for(int i=c;i<=c+101;i++){
            r = Math.min(dp[i],r);
        }
        System.out.println(r);
    }
}

