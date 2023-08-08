import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            int a = Integer.parseInt(br.readLine());
            arr.add(a);
            set.add(a);
        }
        int ans = 1;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int cnt = 1;
            int pre = arr.get(0);
            Integer next = iterator.next();
            for(int i=1;i<n;i++){
                if(arr.get(i).equals(next)) continue;
                if(pre!=arr.get(i)) cnt=1;
                else cnt++; ans = Math.max(ans,cnt);
                pre = arr.get(i);
            }
        }
        System.out.println(ans);
    }
}
