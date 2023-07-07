import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = s[1];
        int count=0;
        int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=1;i<w;i++){
            int leftMax = 0;
            int rightMax = 0;
            for(int j=0;j<i;j++){
                if(map[j]>leftMax) leftMax = map[j];
            }
            for(int k=i+1;k<w;k++){
                if(map[k]>rightMax) rightMax = map[k];
            }
            int compare = Math.min(leftMax,rightMax);
            if(compare>map[i]) count+=compare-map[i];
        }
        System.out.println(count);
    }
}
