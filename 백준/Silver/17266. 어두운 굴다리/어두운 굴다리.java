import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int h = 1;
        while (true){
            int lt=0;
            for(int i=0;i<m;i++){
                if(lt<arr[i]-h) break;
                lt = arr[i]+h;
            }
            if(lt>=n){
                System.out.println(h);
                break;
            }
            h++;
        }
    }
}
