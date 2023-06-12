import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String table = br.readLine();
        boolean eat[] = new boolean[table.length()];
        int count = 0;
        for(int i=0;i<s[0];i++){
            if(table.charAt(i)=='P'){
                int start = Math.max(i-s[1],0);
                int end = Math.min(i+s[1],s[0]-1);
                for(int j=start;j<=end;j++){
                    if(table.charAt(j)=='H' && !eat[j]){
                        count++;
                        eat[j]=true;
                        break;
                    }
                }
            }
        }
        System.out.println(count);


    }
}