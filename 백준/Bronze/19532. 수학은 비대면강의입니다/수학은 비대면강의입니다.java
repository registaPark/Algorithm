import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=-999;i<1000;i++){
            for(int j=-999;j<1000;j++){
                if(arr[0]*i+arr[1]*j==arr[2] && arr[3]*i+arr[4]*j==arr[5]){
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }
    }
}
