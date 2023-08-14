import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class SnowMan{
        int head;
        int body;
        int sum;

        public SnowMan(int head, int body, int sum) {
            this.head = head;
            this.body = body;
            this.sum = sum;
        }
    }
    static int[] arr;
    static int n;
    static int val = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<SnowMan> snowManList = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                snowManList.add(new SnowMan(i,j,arr[i]+arr[j]));
            }
        }
        snowManList.sort((o1, o2) -> o1.sum-o2.sum);
        for(int i=0;i<snowManList.size()-1;i++){
            SnowMan snowMan1 = snowManList.get(i);
            SnowMan snowMan2 = snowManList.get(i + 1);
            if(snowMan1.head==snowMan2.head || snowMan1.head==snowMan2.body || snowMan1.body==snowMan2.head || snowMan1.body==snowMan2.body) continue;
            val = Math.min(val,Math.abs(snowMan1.sum-snowMan2.sum));
            if(val==0) break;
        }
        System.out.println(val);

    }
}
