import java.io.*;
import java.util.ArrayList;

public class Main {
    static int cnt = 0;
    static ArrayList<Integer> vips;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        vips = new ArrayList<>();
        for(int i=0;i<m;i++){
            int vip = Integer.parseInt(br.readLine());
            vips.add(vip);
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            if(vips.contains(i) || vips.contains(i-1)){
                dp[i] = dp[i-1];
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        System.out.println(dp[n]);

    }
}
