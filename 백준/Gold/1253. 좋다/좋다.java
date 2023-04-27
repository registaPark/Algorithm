import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int cnt=0;
        for(int i=0;i<n;i++){
            int lt=0;
            int rt=n-1;
            while(lt<rt && rt<n){
                if(lt==i) lt++;
                if(rt==i) rt--;
                else if(arr[lt]+arr[rt]<arr[i]) lt++;
                else if(arr[lt]+arr[rt]>arr[i])rt-=1;
                else{
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}