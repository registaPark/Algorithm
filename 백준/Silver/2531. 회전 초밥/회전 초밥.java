import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n , d , k , c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = arr[0]; d = arr[1]; k = arr[2]; c = arr[3];
        int[] sushi = new int[n];
        int[] eat = new int[d+1];
        for(int i=0;i<n;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int maxCount = Integer.MIN_VALUE;
        int maxCnt = 0;
        for(int i=0;i<k;i++){
            if(eat[sushi[i]]==0){
                maxCnt++;
            }
            eat[sushi[i]]++;
        }
        if(eat[c]==0) maxCnt++;
        maxCount = Math.max(maxCount,maxCnt);
        for(int i=1;i<n;i++){
            if(eat[c]==0) maxCnt--;
            eat[sushi[i-1]]--;
            if(eat[sushi[i-1]]==0) maxCnt--;
            if(eat[sushi[(i-1+k)%n]]==0) maxCnt++;
            eat[sushi[(i-1+k)%n]]++;
            if(eat[c]==0) maxCnt++;
            maxCount = Math.max(maxCount,maxCnt);
        }
        System.out.println(maxCount);
    }
}
