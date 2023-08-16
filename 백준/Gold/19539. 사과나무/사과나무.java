import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        int cnt = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(arr[i]%2==1) cnt++;
        }
        if(sum%3==0 && sum/3>=cnt) System.out.println("YES");
        else System.out.println("NO");
    }
}
