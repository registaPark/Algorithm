import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int n;
    static int m;
    static int[] res;
    static boolean[] visit;
    static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        set = new HashSet<>();
        res = new int[m];
        visit = new boolean[n];
        Arrays.sort(arr);
        back_tracking(0);
    }

    private static void back_tracking(int cnt) {
        if(cnt==m){
            String str = "";
            for(int i=0;i<m;i++){
                str+=res[i];
            }
            if(!set.contains(str)){
                for(int i=0;i<m;i++){
                    System.out.print(res[i]+" ");
                }
                System.out.println();
            }
            set.add(str);
            return;
        }
        for(int i=0;i<n;i++){
            if(!visit[i] && res[cnt]==0){
                if(cnt==0){
                    visit[i] = true;
                    res[cnt] = arr[i];
                    back_tracking(cnt+1);
                    visit[i] = false;
                    res[cnt] = 0;
                }else{
                    if(res[cnt-1]<=arr[i]){
                        visit[i] = true;
                        res[cnt] = arr[i];
                        back_tracking(cnt+1);
                        visit[i] = false;
                        res[cnt] = 0;
                    }
                }
            }
        }
    }
}
