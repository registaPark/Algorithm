import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> craneList = new ArrayList<>();
        ArrayList<Integer> boxList = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] craneArr = br.readLine().split(" ");
        for (String i : craneArr) craneList.add(Integer.parseInt(i));
        int m = Integer.parseInt(br.readLine());
        String[] boxArr = br.readLine().split(" ");
        for (String i : boxArr) boxList.add(Integer.parseInt(i));
        craneList.sort(Collections.reverseOrder());
        boxList.sort(Collections.reverseOrder());
        if(craneList.get(0)< boxList.get(0)) System.out.println(-1);
        else{
            int count = 0;
            while (!boxList.isEmpty()){
                int k = 0;
                for(int i=0;i<n;){
                    if(k == boxList.size()) break;
                    else if(craneList.get(i)>=boxList.get(k)){
                        boxList.remove(k);
                        i++;
                    }else{
                        k++;
                    }
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
