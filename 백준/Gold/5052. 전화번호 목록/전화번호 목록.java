import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<HashSet<String>> sets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sets = new ArrayList<>();
        for(int k=0;k<t;k++){
            boolean flag = true;
            int n = Integer.parseInt(br.readLine());
            String[] strings = new String[n];
            for(int i=0;i<n;i++){
                strings[i]=br.readLine();
            }
            Arrays.sort(strings);
            for(int i=0;i<n-1;i++){
                if(strings[i+1].startsWith(strings[i])){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if(flag) System.out.println("YES");
        }
    }
}
