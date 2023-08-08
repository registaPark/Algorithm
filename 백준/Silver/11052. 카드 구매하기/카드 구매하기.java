import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i+1] = arr[i];
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                if(i%j==0) dp[i] = Math.max(dp[i],dp[j]*(i/j));
                dp[i] = Math.max(dp[i],dp[i-j]+dp[j]);
            }
        }
        System.out.println(dp[n]);
    }
}
